package com.gorillalogic.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/welcome")
public class HelloController {
 
	/**
	 * A simple web page with a dynamic field
	 * @param model the model to set the proper values
	 * @return the jsp to render
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
 
		model.addAttribute("message", "Hello World");
		return "hello.jsp";
 
	}
 
}