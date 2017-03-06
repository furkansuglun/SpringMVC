package _01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import _01.domain.Person;
import _01.service.MyService;

@Controller
public class HelloController {
	 
	@Autowired
	private MyService myService;
	
	//hangi url i�in hangi methodla kar��lanacak
	@RequestMapping(value="/helloURL" , method=RequestMethod.GET) 
	public String sayHello(ModelMap model) {
		
		//datay� al
		String message = myService.printMessage();
		//
		//
		//datay� request attribute olarak ekle
		//bunun i�in modalmap objesinden yararlanabiliriz.
		model.addAttribute("myMessage" , message);
		
		Person person = new Person("Furkan", "S��l�n");
		
		model.addAttribute("myPerson" , person);
		
		return "01.view/helloMyJSPFile";
		//prefix(WEB-INF/jsp)/01.view/helloMyJSPFile(.jsp)suffix
		
		/*
		 * 
		 *  <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
				<property name="prefix" value="/WEB-INF/jsp"/>
				<property name="suffix" value=".jsp"></property>
			</bean>
		 * 
		 */
		
	}
	
	
	//***********
	// Burada return kisminda view'i donuyoruz.
	// WEB-INF altindaki dosyalara direkt erisim yoktur! Bu sayede guvenlik
	// sagladigi icin projelerde ilgili view dosyalari WEB-INF altinda tutulur.

	// Bu noktada , Spring bizim icin ViewResolver class'lari saglamaktadir.
	
}
