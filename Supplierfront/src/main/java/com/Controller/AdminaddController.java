package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Model.Category;
import com.Model.Supplier;
@Controller
public class AdminaddController {

	@RequestMapping(value={"/adminadd"})
	public ModelAndView show()
	{
		
		ModelAndView mv=new ModelAndView("adminadd");
		return mv;
	}

	@RequestMapping(value={"/supplier"})
	public ModelAndView showSupplier()
	{
		
		ModelAndView mv=new ModelAndView("supplier");
		return mv;
	}
	
}
