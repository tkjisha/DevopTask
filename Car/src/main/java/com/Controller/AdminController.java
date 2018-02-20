package com.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.Model.Category;
import com.Model.Product;
import com.Model.Supplier;

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
	public String showAdminProd(){
		
		return "AdminProductList";
	}
	@RequestMapping(value="/supplier")
	public String showSupplier()
	{		
		return "supplier";
	}
		
	
	@RequestMapping(value="/AddSupplier",method=RequestMethod.POST)
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
	
	@RequestMapping(value="/product")
	public String showProduct(ModelMap m)
	{
		
		List<Category> l=categoryDaoImpl.retrieveCategory();
		m.addAttribute("catList",l);
		List<Supplier> l1=supdaoImpl.retrieveSupplier();
		m.addAttribute("supList",l1);
		return "product";
	}
	
	@RequestMapping(value="/AddProduct",method=RequestMethod.POST)
	public ModelAndView addProduct(@RequestParam("pimage") MultipartFile file,HttpServletRequest req, Model m)
	{
		System.out.println("product add");
		ModelAndView mv=new ModelAndView("product");
		String prname=req.getParameter("pname");System.out.println(prname);
		String prdesc=req.getParameter("desc");System.out.println(prdesc);
		String prprice=req.getParameter("price");System.out.println(prprice);
		String prstock=req.getParameter("stock");System.out.println(prstock);
		String cat=req.getParameter("category");System.out.println(cat);
		String supp=req.getParameter("supplier");System.out.println(supp);
		String primg=req.getParameter("pimage");System.out.println(primg);
		Product prod=new Product();System.out.println(prod);
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
	@RequestMapping(value="/userlogged")
	public void userlogged()
	{
		
	}
	@RequestMapping(value="/error")
	public void error()
	{
		
	}
}
