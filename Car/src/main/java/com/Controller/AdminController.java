package com.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.Model.Category;
import com.Model.Product;
import com.Model.Supplier;
import com.Model.User;

@Controller
public class AdminController {

	@Autowired
	SupplierDaoImpl supdaoImpl;
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	
	@RequestMapping(value="/adminadd")
	public ModelAndView show()
	{
		ModelAndView mv=new ModelAndView("supplier");
		return mv;
	}
		
	@RequestMapping(value="/AdminProductList")
	public ModelAndView showAdminProd(){
		ModelAndView mv=new ModelAndView("AdminProductList");
		List<Product> lp=productDaoImpl.retrieveProduct();
		mv.addObject("plist", lp);
		return mv;
	}
	
	@RequestMapping(value="/ProductList",method=RequestMethod.GET)
	public String showprodlist(HttpServletRequest req,ModelMap m)
	{
	String c=req.getParameter("id");
		List<Product> lp=productDaoImpl.getProdByCid(c);
		m.addAttribute("prodlist", lp);
		return "ProductList";
	}
	
	@RequestMapping(value="/ProductDetails",method=RequestMethod.POST)
	public ModelAndView prodDetail(HttpServletRequest req){
		int pid=Integer.parseInt(req.getParameter("pid"));System.out.println(pid);
		ModelAndView mv=new ModelAndView("ProductDetails");
		Product p=productDaoImpl.findById(pid);
		mv.addObject("prod",p);
		return mv;
	}
	
	@RequestMapping(value="/supplier")
	public String showSupplier()
	{		
		return "supplier";
	}
		
	
	@RequestMapping(value="/admin/AddSupplier",method=RequestMethod.POST)
	public ModelAndView addSupplier(@ModelAttribute("supplier") Supplier supplier,HttpServletRequest req)
	{
		System.out.println("supplier add");
		ModelAndView mv=new ModelAndView("supplier");
		String sid=req.getParameter("sid");System.out.println(sid);
		String supplierName=req.getParameter("supName");System.out.println(supplierName);
		Supplier supp=new Supplier();
		supp.setSid(sid);
		supp.setSupplierName(supplierName);
		boolean res=supdaoImpl.insertSupp(supp);
		if(res==true)
		System.out.println("Data added");
		return mv;
	}
	
	@RequestMapping(value="/category")
	public String showCategory()
	{		
		return "category";
	}
	
	@RequestMapping(value="/AddCategory",method=RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute("category") Category category,HttpServletRequest req,Model m)
	{
		System.out.println("category add");
		ModelAndView mv=new ModelAndView("category");
		String cid=req.getParameter("catId");
		String cName=req.getParameter("catName");
	 
		Category cat=new Category();
		cat.setCatId(cid);
		cat.setCatName(cName);
		boolean res=categoryDaoImpl.insertCategory(cat);
		List<Category> l=categoryDaoImpl.retrieveCategory();
		m.addAttribute("catList",l);
		
		if(res==true)
		System.out.println("Category added");
		return mv;
	}
	
	@RequestMapping(value="/product" ,method=RequestMethod.GET)
	public String showProduct(ModelMap m)
	{
		
		List<Category> l=categoryDaoImpl.retrieveCategory();
		m.addAttribute("catList",l);
		List<Supplier> l1=supdaoImpl.retrieveSupplier();
		m.addAttribute("supList",l1);
		return "product";
	}
	@RequestMapping(value="/product" ,method=RequestMethod.POST)
	public String showProduct(HttpServletRequest req,ModelMap m)
	{
		int pid=Integer.parseInt(req.getParameter("id"));
		System.out.println(pid);
		Product p=productDaoImpl.findById(pid); 
		m.addAttribute("prod", p);
		return "product";
	}
	
	@RequestMapping(value="/Delprod/{pid}",method=RequestMethod.POST)
	public String delproduct(@PathVariable("pid") int pid)
	{
		System.out.println("del"+pid);
		productDaoImpl.deleteProd(pid);
		return "redirect:/AdminProductList";
	}
	
	@RequestMapping(value="/Updateprod/{pid}",method=RequestMethod.POST)
	public String updateProd(@PathVariable("pid")int pid,HttpServletRequest req)
	{
		System.out.println("updt"+pid);
		Product p=productDaoImpl.findById(pid);
		p.setPrice(Float.parseFloat(req.getParameter("price")));
		p.setStock(Integer.parseInt(req.getParameter("stock")));
		productDaoImpl.updateProd(p);System.out.println(p);
		return "redirect:/AdminProductList";
	}
	
	@RequestMapping(value="/admin/AddProduct",method=RequestMethod.POST)
	public ModelAndView addProduct(@RequestParam("pimage") MultipartFile file,HttpServletRequest req, Model m)
	{
		System.out.println("product add");
		ModelAndView mv=new ModelAndView("product");
		String prname=req.getParameter("pname");
		String prdesc=req.getParameter("desc");
		String prprice=req.getParameter("price");
		String prstock=req.getParameter("stock");
		String cat=req.getParameter("category");
		String supp=req.getParameter("supplier");
		String primg=req.getParameter("pimage");
		Product prod=new Product();
		prod.setPname(prname);
		prod.setDesc(prdesc);
		prod.setPrice(Float.parseFloat(prprice));		
		prod.setStock(Integer.parseInt(prstock));
		prod.setCatid(cat);
		prod.setSid(supp);
		prod.setImgname(primg);
		String filepath=req.getSession().getServletContext().getRealPath("/");System.out.println(filepath);
		String filename=file.getOriginalFilename();System.out.println(filename);
		prod.setImgname(filename);
		boolean res=productDaoImpl.insertProd(prod);
		System.out.println(res);
	   try{
	    	byte [] imagebyte=file.getBytes();
	    	BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename)); 
	    	bos.write(imagebyte);
	    	bos.close();
	    }catch(Exception e)
	    {
	    	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
	    } 
		return mv;
	}
	
/*	@RequestMapping(value="/Cart/{pid}", method = RequestMethod.POST)
	public ModelAndView showCart(@PathVariable("pid") int pid)
	{
		System.out.println("cart"+pid);
		Product p=productDaoImpl.findById(pid);
		ModelAndView mv=new ModelAndView("Cart");
		mv.addObject("prod",p);
		return mv;
	}*/
	@RequestMapping(value="/login", method =RequestMethod.GET)
	 public String login(ModelMap model,HttpServletRequest req) {
		System.out.println("login");
		
	  return "login";
	 
	 }
	@RequestMapping(value="/userlogged",method =RequestMethod.POST)	
	public String userlogged(HttpServletRequest req,Principal pr)
	{System.out.println("userlogin");
		Principal p=req.getUserPrincipal();System.out.println("userlogin"+p);
		Principal prl =(Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	//	String pname = authentication.getName();
		System.out.println("userlogin"+prl);
		return "index";
	}
	@RequestMapping(value="/error")	 
	public String error()
	{System.out.println("error");
	
		return "login";
	}
	 
	 @RequestMapping(value="/logout", method = RequestMethod.GET)
	 public String logout(ModelMap model) {
	 
	  return "login";
	 
	 }
}
