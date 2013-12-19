package uk.co.eelpieconsulting.monitoring.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@EnableAutoConfiguration
@Controller
public class HomepageController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView homepage() {
		ModelAndView mv = new ModelAndView("homepage");		
		return mv;
	}
	
}
