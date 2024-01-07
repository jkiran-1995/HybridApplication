package com.HybridAutomationApplication.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		File src = new File("./configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is :"+e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url = pro.getProperty("BaseURL");
		return url;
	}
	public String getUsername() {
		String username = pro.getProperty("Username");
		return username;
	}
	public String getPassword() {
		String Password = pro.getProperty("password");
		return Password;
	}
	public String getchromepath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	public String getfirefoxpath() {
		String firefoxpath1 = pro.getProperty("firefoxpath");
		return firefoxpath1;
	}


}
