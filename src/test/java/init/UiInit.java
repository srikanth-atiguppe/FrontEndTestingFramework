package init;

import org.openqa.selenium.WebDriver;

import driver.DriverUtil;
import utils.ReadPropFile;
import web.driver.InitDriver;

public class UiInit {

	public static ReadPropFile readTestPropFile = new ReadPropFile();
	public static InitDriver initDriver;
	public static String defaultUrl;
	public static String browser;
	public static WebDriver driver;
	public static DriverUtil driverUtil;
	
	public void init() {
		readTestPropFile.loadDefaultPropFile();
		defaultUrl = readTestPropFile.getPropertyValue("DefaultURL");
		browser = readTestPropFile.getPropertyValue("Browser");
		initDriver = new InitDriver(browser);
		driverUtil = new DriverUtil();
		driver = driverUtil.getDriver();
		driverUtil.launchDefaultUrl();
	}
	
	public void shutdownDriver() {
		driverUtil.closeDriver();
	}
}
