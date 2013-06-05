package com.gorillalogic.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; 

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import org.springframework.test.context.web.WebAppConfiguration;  
import org.springframework.test.web.servlet.MockMvc;  
import org.springframework.test.web.servlet.setup.MockMvcBuilders;  
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringJUnit4ClassRunner.class)  
@WebAppConfiguration  
@ContextConfiguration(classes=BaseTestConfig.class)  
public class HelloTest {  
	      
	@Autowired  
	private WebApplicationContext wac;  
	
	private MockMvc mockMvc;  
	      
	@Before  
	public void init() {  
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}  
	      
	/**
	 * A test for a simple web app
	 * @throws Exception
	 */
	@Test  
	public void testWelcome() throws Exception {  
		
		// Test data set up
		String messageExpectedValue = "Hello World"; 
		String urlPath = "/welcome";
		String attributeName = "message";
		String viewName = "hello.jsp";
		
		// Test execution
		mockMvc.perform(get(urlPath))  
		.andExpect(status().isOk())  // validates the response status
		.andExpect(model().attribute(attributeName, messageExpectedValue)) // validates the response content
		.andExpect(view().name(viewName)); // validates the response view element
	}  

	/**
	 * A test for a simple json webservice
	 * @throws Exception
	 */
	@Test  
	public void testGreet() throws Exception {  
		
		// Test data set up
		String messageExpectedValue = "Hello World";
		String urlPath = "/greet";
		String jsonPath = "$.message";
		
		// Test execution
		mockMvc.perform(get(urlPath))  
		.andExpect(status().isOk())  //validates the response status 
		.andExpect(jsonPath(jsonPath).value(messageExpectedValue)); //validates the response content
	}  
}
