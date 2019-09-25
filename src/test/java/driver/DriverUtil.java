package driver;

import org.openqa.selenium.WebDriver;

import init.UiInit;

public class DriverUtil extends UiInit {

	public DriverUtil() {
		driver = initDriver.getDefaultDriver();
	}
	
	public void launchDefaultUrl() {
		driver.get(defaultUrl);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeDriver() {
		try {
				if (initDriver != null) {
					initDriver.closeDriver();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
