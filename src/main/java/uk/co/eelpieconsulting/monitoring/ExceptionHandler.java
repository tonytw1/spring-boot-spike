package uk.co.eelpieconsulting.monitoring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import uk.co.eelpieconsulting.monitoring.exceptions.AuthRequiredException;

@Component
public class ExceptionHandler implements HandlerExceptionResolver, Ordered {

	private final static Logger log = Logger.getLogger(ExceptionHandler.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response,
			Object handler, 
			Exception e) {
		
		log.info("Handling exception of type: " + e.getClass());		
		if (e instanceof AuthRequiredException) {			
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return new ModelAndView("error");
		}
		
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ModelAndView("error");
	}
	
	@Override
	public int getOrder() {
		return Integer.MIN_VALUE;
	}
	
}
