package com.maveric.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

	public static Properties getPropertiesDetails(String fileNameWithPath) throws IOException {
		FileInputStream fileIn=new FileInputStream(fileNameWithPath);
		Properties prop=new Properties();
		prop.load(fileIn);
		
		return prop;		
	}
	public static String getValueForKey(String fileNameWithPath,String key) throws IOException {
		FileInputStream fileIn=new FileInputStream(fileNameWithPath);
		Properties prop=new Properties();
		prop.load(fileIn);
		String value=prop.getProperty(key);
		return value;	
		
	}
}
