package interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuditingInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = Logger.getLogger("auditLogger");
	private String user;
	private String productId;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandler");
		
		if(request.getRequestURI().endsWith("add")) {
			if(request.getMethod().equals("GET")) {
				//
				logger.info("preHandle : GET request");
			}
			if(request.getMethod().equals("POST")) {
				//
				logger.info("preHandle : POST request");
			}
		}
		
		return true;
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCOmpletion");
		
		if(request.getRequestURI().endsWith("add") && response.getStatus() == 302) {
			logger.info(String.format("A new product [%s] Added by %s on %s " , productId , user , getCurrentTime()));
		}
		
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("proHandler");
		
		if(request.getRequestURI().endsWith("add")) {
			if(request.getMethod().equals("GET")) {
				System.out.println("postHandle : GET request");
			}
			if(request.getMethod().equals("POST")) {
				System.out.println("postHandle : POST request");
			}
		}
		
	}
	
	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}

	
}
