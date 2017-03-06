package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class OrderController extends MultiActionController {

	//public (ModelAndView | Map | String | void) actionName(HttpServletRequest request,
	// HttpServletResponse response, [,HttpSession] [,AnyObject]);
	
	public String addOrder(HttpServletRequest req , HttpServletResponse resp) {
		req.setAttribute("myMessage", "OrderController#add");
		return "addOrderPage";
	}
	
	
	public ModelAndView getOrder(HttpServletRequest req , HttpServletResponse resp) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("getOrderPage");
		modelAndView.addObject("myMessage" , "OrderController#getOrder");
		
		return modelAndView;
	}
	
	//url => ../listOrder
	public String listOrder(HttpServletRequest req , HttpServletResponse resp) {
		req.setAttribute("myMessage", "OrderController#listOrder");
		return "listOrderPage";
	}
	
}
