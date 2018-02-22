package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.Model.Category;
import com.Model.User;

@Controller
public class IndexController {

	@Autowired
	CategoryDaoImpl categoryDaoImpl ;
	
	@RequestMapping(value="/")
	public String show(ModelMap m)
	{
		List<Category> l=categoryDaoImpl.retrieveCategory();
		m.addAttribute("catList",l);
		return "index";
	}
	
	@RequestMapping(value="/register")
	public ModelAndView showRegister(){
		
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
	@RequestMapping(value="/login")
	public String showLogin(){
		return "login";
	}
}
