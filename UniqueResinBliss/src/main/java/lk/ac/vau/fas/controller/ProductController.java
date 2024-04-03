package lk.ac.vau.fas.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import lk.ac.vau.fas.models.MyItemList;
import lk.ac.vau.fas.models.Product;
import lk.ac.vau.fas.service.MyItemListService;
import lk.ac.vau.fas.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired //to call the same method in the service class
	private ProductService service;
	
	
	@Autowired
	private MyItemListService myItemService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/add_product")//to add a item to the list
	public String addItem() {
		return "Add Product";
	}

	@GetMapping("/available_items")//to check the available items
	public ModelAndView getAllItems() { //send the data from controller to view ,so it used model view
		List<Product>list=service.getAllProducts();
		return new ModelAndView("ProductList","product",list);
		
		
	}
	
	@PostMapping("/save") //to handle the post
	private String addProduct(@ModelAttribute Product p) {
		service.save(p);
		return "redirect:/available_items"; //to return the desired page
	}
	
	@GetMapping("/my_items")
	public String getMyItems(org.springframework.ui.Model model) {
		
		List<MyItemList>list=myItemService.getAllMyItems();
		model.addAttribute("product",list);
		return "myItems";
	}
	
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Product p=service.getItemById(id);
		MyItemList mp = new MyItemList(p.getId(),p.getName(),p.getColor(),p.getPrice());
	    myItemService.saveMyItems(mp);
	    return "redirect:/my_items";
	}  
	
	@RequestMapping("editItem/{id}")
	public String editItem(@PathVariable("id")int id,org.springframework.ui.Model model) {
		Product p=service.getItemById(id);
		model.addAttribute("product",p);
		return "itemEdit";
	}
	
	@RequestMapping("deleteItem/{id}")
	public String deleteItem(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_items";
	}

}


