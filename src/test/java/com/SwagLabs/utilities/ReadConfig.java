package com.SwagLabs.utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {
Properties properties;
String path = "C:\\Users\\HP\\Desktop\\Maven Project\\MyStoreV1\\Configuration\\config.properties";
 public ReadConfig() {
	try {
	 properties = new Properties();
	//READ File

		FileInputStream fis = new FileInputStream(path);
	    properties.load(fis);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 }
public String getbasrUrl() {
String value=	properties.getProperty("baseUrl");
if (value != null)
	return value;
else  throw new RuntimeException("Url value is not specified");

}
public String getBrowser() {
	String value = properties.getProperty("browser");
 if (value !=null) 
	 return value;
 else throw new RuntimeException("browser valus is not specified");

}
// for logging


}
