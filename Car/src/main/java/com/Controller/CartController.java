package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.ProductDaoImpl;
import com.Model.Product;

@Controller
public class CartController {

	@Autowired
	ProductDaoImpl productDaoImpl;

	@RequestMapping(value="/Cart/{pid}", method = RequestMethod.POST)
	public ModelAndView showCart(@PathVariable("pid") int pid)
	{
		System.out.println("cart"+pid);
		Product p=productDaoImpl.findById(pid);
		ModelAndView mv=new ModelAndView("Cart");
		mv.addObject("prod",p);
		return mv;
	}
	@RequestMapping(value="/checkout", method=RequestMethod.POST)
	public String checkout()
	{
		System.out.println("checkout");
	//	ModelAndView mv=new ModelAndView("checkout");
		return "checkout";
	}
	
	@RequestMapping(value="/addshop")
	public String addshop(){
		
		return "redirect:/ProductList";
	}
}
