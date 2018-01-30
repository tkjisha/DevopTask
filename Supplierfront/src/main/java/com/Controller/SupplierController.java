package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.SupplierDao;
import com.Model.Supplier;
import com.DaoImpl.SupplierDaoImpl;

@Controller
public class SupplierController {

	@Autowired
	SupplierDao supdao;
	@RequestMapping(value={"/supplier"})
	public ModelAndView show()
	{
		//m.addAttribute();
		ModelAndView mv=new ModelAndView("supplier","supplier",new Supplier());
		return mv;
	}
	@RequestMapping(value="AddSupplier",method=RequestMethod.POST)
	public ModelAndView addSupplier(@RequestParam("sid") String sid,@RequestParam("supplierName") String supplierName)
	{
		Supplier supp=new Supplier();
		supp.setSid(sid);
		supp.setSupplierName(supplierName);
		boolean res=supdao.insertSupp(supp);
		System.out.println("Data added");
		
		ModelAndView mv=new ModelAndView("supplier","supplier",new Supplier());
		return mv;
	}
	@RequestMapping(value="UpdateSupplier/{sid}",method=RequestMethod.GET)
	public ModelAndView updateSupplier(@PathVariable("sid") String sid)
	{
		System.out.println("Data updt");
		Supplier sup1=supdao.get(sid);
		
		
		ModelAndView mv=new ModelAndView("supplier","supplier",new Supplier());System.out.println("Data up[dated");
		return mv;
	}
	
}
