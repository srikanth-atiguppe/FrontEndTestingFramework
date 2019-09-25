package web.elementactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {

WebDriver driver;
	
	public Button(WebDriver driver) {
		this.driver = driver;
	}
	
	public void click(By byElem) {
		WebElement button = driver.findElement(byElem);
		button.click();
	}
}
