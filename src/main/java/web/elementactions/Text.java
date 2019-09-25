package web.elementactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Text {
	
WebDriver driver;
	
	public Text(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getText(By byElem) {
		WebElement element = driver.findElement(byElem);
		return element.getText();
	}


}
