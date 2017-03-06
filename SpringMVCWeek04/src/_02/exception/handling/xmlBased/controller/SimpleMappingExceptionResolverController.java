package _02.exception.handling.xmlBased.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import _02.exception.handling.xmlBased.model.DatabaseException;

@Controller
public class SimpleMappingExceptionResolverController {

	@RequestMapping("/numberFormatException")
	public ModelAndView throwNumberFormatException() {
		throw new NumberFormatException();
	}
	
	@RequestMapping("/nullPointerException")
	public ModelAndView thrownullPointerException() {
		throw new NullPointerException();
	}
	
	@RequestMapping("/databaseException")
	public ModelAndView throwdatabaseException() throws Exception {
		throw new DatabaseException("DB-1000" , "DB Connection TimeOut");
	}
		
}
