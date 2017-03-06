package controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Product;
import service.ProductService;
import validator.ProductValidator;


@Controller
@RequestMapping("/products/management")
public class ProductManagementController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductValidator productValidator;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	// http://localhost:8080/SpringMVCWeek03/products/management/add
	public String getNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
		// newProduct.setDescription("default description");
		 newProduct.setCondition("new");
		 newProduct.setCategory("Tablet");
		 newProduct.setManufacturer("Samsung");
		return "view/productAdd";
	}

	/*VALIDATION 1
	 * @RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded , BindingResult bindingResult) {
		
		productValidator.validate(productToBeAdded, bindingResult); //validator'i cagir
	
		if(bindingResult.hasErrors()){
			return "view/productAdd";
	}		
	productService.addProduct(productToBeAdded);
		return "redirect:/products";
	}
	//MOdelAttribute veriyi forma  bind etmek için kullanýlýr
*/	
	
	/*
	 * 1 @Valid Product
	 * 2 validate metodunu çaðýrmadýk
	 * 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product productToBeAdded , BindingResult bindingResult) {
		
		//@valid for validation of profuct
	
		if(bindingResult.hasErrors()){
			return "view/productAdd";
	}		
	productService.addProduct(productToBeAdded);
		return "redirect:/products";
	}
	
	// referenceData
	@ModelAttribute("manufacturerList")
	public List<String> prepareManufacturerList() {
		return Arrays.asList("Apple", "Google", "Samsung");
	}

	// referenceData
	@ModelAttribute("categoryList")
	public List<String> prepareCategoryList() {
		return Arrays.asList("Laptop", "Tablet", "SmartPhone");
	}

	// referenceData
	@ModelAttribute("conditionMap")
	public Map<String, String> prepareConditionMap() {
		Map<String, String> conditions = new HashMap<String, String>();
		conditions.put("new", "New");
		conditions.put("old", "Old");
		conditions.put("refurbished", "Refurbished");
		return conditions;
	}
}
