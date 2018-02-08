package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.SupplierDao;
import com.DaoImpl.SupplierDaoImpl;
import com.Model.Supplier;

@Controller
public class AdminsupplierController {

	@Autowired
	SupplierDaoImpl supdao;
	@RequestMapping(value={"/adminsupplier"})
	public ModelAndView show()
	{
		//System.out.println("sup");
		ModelAndView mv=new ModelAndView("supplier","supplier",new Supplier());
		mv.addObject("pageval","supplier");
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
}
