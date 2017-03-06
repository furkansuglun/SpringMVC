package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class Page2Controller extends AbstractController {

	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		 ModelAndView modelAndView = new ModelAndView("myPage2");
		 modelAndView.addObject("myMessage" , "Page2Controller#");
		
		return modelAndView;
	}
}
