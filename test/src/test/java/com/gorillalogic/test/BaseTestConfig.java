package com.gorillalogic.test;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.*;

/**
 * The context to use in the Unit tests
 * @author jquiros
 *
 */
@Configuration
@ComponentScan("com.gorillalogic.test")
@EnableWebMvc
public class BaseTestConfig {
	
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

}