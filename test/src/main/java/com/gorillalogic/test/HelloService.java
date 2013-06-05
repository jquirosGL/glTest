package com.gorillalogic.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * A webservice returning a hello world json message
 * @author jquiros
 *
 */
@RequestMapping("/greet")
@Controller
public class HelloService {

	/**
	 * The responder for the web service, it returns a simple json response with a message, in this case "Hello World"
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody SimpleResponse getGreet() {
		SimpleResponse response = new SimpleResponse();
		response.setMessage("Hello World");
		return response;
	}
}
