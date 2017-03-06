package configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


//bu sayfayý web xml deki Dispatcher sercleti çaðýrma ve mapping eklem iþlemleriyle hatýrlýyabiliriz.

public class RegisterInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//1)AnnotationConfigWebApplicationContext objesi olustur
		//2)register metoduna configuration classi ver.
		AnnotationConfigWebApplicationContext configWebApplicationContext = 
				new AnnotationConfigWebApplicationContext();
		
		configWebApplicationContext.register(BeanConfiguration.class);
		
		//bu kisim Servlet 3.0 da gelen dinamik olarak servlet ekleme ozelligi.
		DispatcherServlet dispatcherServlet = new DispatcherServlet(configWebApplicationContext);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		
		
		
	}

}
