package com.foo;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

public class SubSetApplicationContextInitializer implements
		ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {

	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("Subset initializer called");
		HobbyOnlyPropertySource hobbyOnlyPropertySource = new HobbyOnlyPropertySource(
				"hobby");
		applicationContext.getEnvironment().getPropertySources()
				.addFirst(hobbyOnlyPropertySource);
	}

	public int getOrder() {
		return 1;
	}
}
