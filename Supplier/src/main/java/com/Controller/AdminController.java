package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.SupplierDaoImpl;
import com.Model.Supplier;

@Controller
public class AdminController {

	
	
	@RequestMapping(value="/adminadd")
	public ModelAndView show()
	{System.out.println("show");
		ModelAndView mv=new ModelAndView("adminadd");
		return mv;
	}
	
	@Autowired
	SupplierDaoImpl supdaoImpl;
	
	@RequestMapping(value="/supplier")
	public ModelAndView showSupplier()
	{System.out.println("show");
		ModelAndView mv=new ModelAndView("supplier");
		return mv;
	}
		
	
	@RequestMapping(value="/AddSupplier",method=RequestMethod.POST)
	public ModelAndView addSupplier(@RequestParam("Sid") String sid,@RequestParam("supplierName") String supplierName)
	{System.out.println("Data add");
		ModelAndView mv=new ModelAndView("supplier","supplier",new Supplier());
	 //	mv.addObject("supplier", new Supplier());
			Supplier supp=new Supplier();
		supp.setSid(sid);
		supp.setSupplierName(supplierName);
		boolean res=supdaoImpl.insertSupp(supp);
		System.out.println("Data added");
		
		
		return mv;
	}
	
	@RequestMapping(value="/category")
	public ModelAndView showCategory()
	{System.out.println("show");
		ModelAndView mv=new ModelAndView("category");
		return mv;
	}
	
}
