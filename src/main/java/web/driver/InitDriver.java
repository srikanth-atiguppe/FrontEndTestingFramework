package web.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class InitDriver {

	protected WebDriver driver;
	public String browserType;
	
	public InitDriver(String browserType) {
		this.browserType = browserType;
	}
	
	public InitDriver() {
	}

	public WebDriver getDefaultDriver() {
		try {
			getDefaultDriver(browserType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public WebDriver getDefaultDriver(String browser) {
		try {
				if (driver!=null) {
					return driver;
				}
				if (browser.equalsIgnoreCase("Chrome")) {
					driver = getChromeDriver();
				} else if (browser.equalsIgnoreCase("Firefox")) {
					driver = getFirefoxDriver();
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
				return driver;
	}
	
	public WebDriver getChromeDriver() {
		try {
				if (driver!=null) {
					return driver;
				}
			System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			opt.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
			opt.setAcceptInsecureCerts(true);
			opt.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
			opt.addArguments("disable-infobars");
			driver = new ChromeDriver(opt);
			} catch (Exception e) {
				e.printStackTrace();
			}
	return driver;
		}	

	public WebDriver getFirefoxDriver() {
		try {
				if (driver!=null) {
					return driver;
				}
			System.setProperty("webdriver.gecko.driver", "lib/drivers/geckodriver.exe");
			FirefoxOptions opt = new FirefoxOptions();
			opt.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			opt.setAcceptInsecureCerts(true);
			opt.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
			driver = new FirefoxDriver(opt);
			} catch (Exception e) {
				e.printStackTrace();
			}
	return driver;
		}
	
	public void closeDriver() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
