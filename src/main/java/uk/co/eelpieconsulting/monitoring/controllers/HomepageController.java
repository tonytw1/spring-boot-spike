package uk.co.eelpieconsulting.monitoring.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.co.eelpieconsulting.monitoring.exceptions.AuthRequiredException;

@EnableAutoConfiguration
@Controller
public class HomepageController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView homepage(@RequestHeader(value="widget", required=false) String widget) {
		if (widget == null) {
			throw new AuthRequiredException();
		}
		
		ModelAndView mv = new ModelAndView("homepage");
		return mv;
	}
	
}
