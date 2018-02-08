package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.UserDaoImpl;
import com.Model.User;

@Controller
public class PageController {

	@RequestMapping(value="/")
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		return mv;
	}
	@RequestMapping(value="/register")
	public ModelAndView show(){
		
		ModelAndView mv=new ModelAndView("register");
		mv.addObject("user", new User());
		return mv;
	}
	@Autowired(required=true)
	UserDaoImpl userdaoImpl;
	@RequestMapping(value="/AddUser",method=RequestMethod.POST)
	public ModelAndView AddUser(@ModelAttribute("user")User user){
		
		ModelAndView mv=new ModelAndView("register");
		user.setRole("ROLE_USER");
		user.setEnabled(false);
		userdaoImpl.insertUser(user);
		return mv;
	}
}
