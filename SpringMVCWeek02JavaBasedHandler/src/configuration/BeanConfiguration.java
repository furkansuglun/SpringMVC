package configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import controller.Page1Controller;
import controller.Page2Controller;
import controller.Page3Controller;



@Configuration
public class BeanConfiguration {

	@Bean
	public Page1Controller page1Controller() {
		return new Page1Controller();
	}
	
	@Bean
	public Page2Controller page2Controller() {
		return new Page2Controller();
	}
	
	@Bean
	public Page3Controller page3Controller() {
		return new Page3Controller();
	}
	
	@Bean
	public ViewResolver createViewResolver(){
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	@Bean
	public HandlerMapping createHanflerMapping() {
		SimpleUrlHandlerMapping simpleUrlHandlerMapping =  new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();
		mappings.put("/page1", "page1Controller");
		mappings.put("/page1MyURL", "page1Controller");
		mappings.put("/page1MyURLAddress", "page1Controller");
		mappings.put("/page2", "page2Controller");
		mappings.put("/page3", "page3Controller");
		
		simpleUrlHandlerMapping.setMappings(mappings);
		
		return simpleUrlHandlerMapping;
	}
	
	
}
