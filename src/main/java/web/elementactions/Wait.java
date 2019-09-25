package web.elementactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	WebDriver driver;
	
	public Wait(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitUntilVisible(By byElem) {
		try {
			new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(driver.findElement(byElem)));
		} catch (Exception e) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
