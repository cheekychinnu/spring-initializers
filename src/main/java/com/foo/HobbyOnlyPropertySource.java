package com.foo;

import java.util.Properties;

import org.springframework.core.env.PropertySource;

public class HobbyOnlyPropertySource extends PropertySource<Properties> {

	static Properties source = new Properties();
	
	public HobbyOnlyPropertySource(String name) {
		super(name, source);
		source.setProperty("hobby", "running");
	}

	@Override
	public Object getProperty(String key) {
		return getSource().get(key);
	}
}
