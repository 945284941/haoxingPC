package com.qlzy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadpropertiesUtil {
	 public Properties loadproperties(String name) {
			Properties propertie = new Properties();
			InputStream inputFile;
			try {
				inputFile = this.getClass().getClassLoader().getResourceAsStream(
						name);
				propertie.load(inputFile);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return propertie;
		}
}
