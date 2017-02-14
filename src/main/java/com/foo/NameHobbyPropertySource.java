package com.foo;

import java.util.Properties;

import org.springframework.core.env.PropertySource;

public class NameHobbyPropertySource extends PropertySource<Properties> {

	static Properties source = new Properties();
	
	public NameHobbyPropertySource(String name) {
		super(name, source);
		source.setProperty("name", "chinnu");
		source.setProperty("hobby", "cycling");
	}

	@Override
	public Object getProperty(String key) {
		return getSource().get(key);
	}
}
