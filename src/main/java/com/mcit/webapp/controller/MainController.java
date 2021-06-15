package com.mcit.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcit.webapp.dao.EProductDAO;
import com.mcit.webapp.entity.EProduct;

@Controller
public class MainController {
	
	@Autowired
	EProductDAO eProductDAO;
	
	@RequestMapping(value="/list-product", method=RequestMethod.GET)
	public String listProducts(ModelMap map) {
		List<EProduct> list = eProductDAO.getProducts();
		map.addAttribute("list",list);
		return "list-products";
	}

	@RequestMapping(value="/addproduct" , method=RequestMethod.GET)
	public String addProduct(ModelMap map) {
		EProduct eProduct = new EProduct();
		map.put("eProduct", eProduct);
		return "addproduct";
	}
	
	@RequestMapping(value="/add-product" , method=RequestMethod.POST)
	public String addProductPost(ModelMap map,@ModelAttribute("eProduct") EProduct eProduct) {
		eProductDAO.addProduct(eProduct);
		return "success";
	}
}
