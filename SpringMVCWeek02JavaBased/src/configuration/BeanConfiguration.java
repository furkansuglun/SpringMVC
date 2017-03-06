package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import controller.CustomerController;

//bu sayfay� [servlet-name]-servlet.xml gibi d���nebilriz. 

@Configuration
public class BeanConfiguration {

	@Bean
	public CustomerController createCustomerController(){		
		return new CustomerController();
	}
	
	@Bean
	public ViewResolver createViewResolver(){
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	
}
