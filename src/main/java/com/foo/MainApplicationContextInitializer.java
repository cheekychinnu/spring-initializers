package com.foo;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class MainApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("Main initializer called");
		NameHobbyPropertySource nameHobbyPropertySource = new NameHobbyPropertySource("name-hobby");
		applicationContext.getEnvironment().getPropertySources().addFirst(nameHobbyPropertySource);
	}

}
