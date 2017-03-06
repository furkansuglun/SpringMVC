package _01.request.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/test")
public class TestController {

	@RequestMapping(method={RequestMethod.GET})
	public String myMethod(Model model) {
		model.addAttribute("message","TestCOntroller#myMethod");
		return "01.request.mapping.view/testPage";
	}
	
	@RequestMapping(method={RequestMethod.GET} , value="/myMethod2")
	public String myMethod2(Model model) {
		model.addAttribute("message","TestCOntroller#myMethod2");
		return "01.request.mapping.view/testPage";
	}
	
	
	
}
