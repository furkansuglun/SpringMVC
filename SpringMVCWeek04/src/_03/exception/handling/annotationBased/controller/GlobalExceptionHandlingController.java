package _03.exception.handling.annotationBased.controller;

import java.sql.SQLDataException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandlingController {

	@ExceptionHandler({SQLException.class,SQLDataException.class})
	public String handleGenericSQLException() {
		System.out.println("handleGenericSQLException");
		return "03.exception.handling.annotationBased.view/genericSqlException";
	}
	
	@ExceptionHandler({IndexOutOfBoundsException.class})
	public ModelAndView handleGenericIndexOutOfBoundsException(HttpServletRequest req, Exception exception) {
		System.out.println("handleGenericIndexOutOfBoundsException...");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", exception);
		modelAndView.setViewName("03.exception.handling.annotationBased.view/genericIndexOutOfBoundsException");
		return modelAndView;
	}
	
}
