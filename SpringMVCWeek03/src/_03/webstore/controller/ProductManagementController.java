package _03.webstore.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import _03.webstore.domain.Product;
import _03.webstore.service.ProductService;


@Controller
@RequestMapping("/products/management")
public class ProductManagementController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	// http://localhost:8080/SpringMVCWeek03/products/management/add
	public String getNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
		 newProduct.setDescription("default description");
		 newProduct.setCondition("new");
		 newProduct.setCategory("Tablet");
		 newProduct.setManufacturer("Samsung");
		return "03.webstore.view/productAdd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded) {
		productService.addProduct(productToBeAdded);
		return "redirect:/products";
	}
	//MOdelAttribute veriyi forma  bind etmek için kullanýlýr
	
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
