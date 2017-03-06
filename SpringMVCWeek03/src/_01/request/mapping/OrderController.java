package _01.request.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class OrderController {

	@RequestMapping("/add")
	//http://localhost:8080/SpringMVCWeek03/order/add
	public String addOrder(Model model) {
		model.addAttribute("message" , "OrderController#addOrder");
		return "01.request.mapping.view/orderPage";
	}
	
	@RequestMapping("/list")
	//http://localhost:8080/SpringMVCWeek03/order/list
	public String listOrder(ModelMap modelMap) {
		modelMap.addAttribute("message" , "OrderController#listOrder");
		return "01.request.mapping.view/orderPage";
	}
	
	@RequestMapping(value={"/delete" , "/remove"})
	//http://localhost:8080/SpringMVCWeek03/order/remove
	//http://localhost:8080/SpringMVCWeek03/order/delete
	public ModelAndView deleteOrder() {
		ModelAndView modelAndView = new ModelAndView("01.request.mapping.view/orderPage");
		modelAndView.addObject("message" , "OrderController#deleteOrder");
		return modelAndView;
	}
}
