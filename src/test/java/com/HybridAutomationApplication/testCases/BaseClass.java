package com.HybridAutomationApplication.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.HybridAutomationApplication.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String BaseURL = readconfig.getApplicationURL();
	public String Username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static ChromeOptions Options;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger = Logger.getLogger("HybridAutomation");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
		Options = new ChromeOptions();
		Options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(Options);
		}
		else if(br.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver = new FirefoxDriver();
		}
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
