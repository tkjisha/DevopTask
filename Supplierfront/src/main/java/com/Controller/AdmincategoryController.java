package com.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CategoryDaoImpl;
import com.Model.Category;
import com.Model.Supplier;

@Controller
public class AdmincategoryController {

	
	
	@Autowired
	CategoryDaoImpl catDaoImpl;
	@RequestMapping(value={"/admincategory"})
	public ModelAndView show()
	{
		System.out.println("cat");
		ModelAndView mv=new ModelAndView("category","category",new Category());
		mv.addObject("pageval","category");
		return mv;
	}
	@RequestMapping(value="AddCategory",method=RequestMethod.POST)
	public ModelAndView addSupplier(@RequestParam("catId") String catId,@RequestParam("catName") String catName)
	{System.out.println("addcat");
		Category cat=new Category();
		cat.setCatId(catId);
		cat.setCatName(catName);
		
		catDaoImpl.insertCategory(cat);
		System.out.println("Data added");
		
		ModelAndView mv=new ModelAndView("category","category",new Category());
		return mv;
	}
}
