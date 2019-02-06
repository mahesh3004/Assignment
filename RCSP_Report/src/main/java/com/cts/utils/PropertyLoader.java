package com.cts.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

	public static Properties getPropertiesFromResources() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = ClassLoader.getSystemClassLoader().getSystemResourceAsStream("conf.properties");
			prop.load(input);
		} catch (IOException io) {
			io.printStackTrace();

		}
		return prop;
	}
}
