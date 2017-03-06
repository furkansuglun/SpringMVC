package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@RequestMapping(value="/login")
	public ModelAndView customerLogin() {
		
		ModelAndView modelAndView = new ModelAndView("login"); //gidilecek sayfa ad� 
		
		modelAndView.addObject("myMessage" , "Hello Customer "); //gidilen sayfada �a��ralacak isim , g�sterilecek data
		
		return modelAndView;
	}
	
}
