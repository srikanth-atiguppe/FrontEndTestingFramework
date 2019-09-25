package web.elementactions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Generic {

WebDriver driver;
	
	public Generic(WebDriver driver) {
		this.driver = driver;
	}
	
	public void jsClick(By byElem) {
		WebElement element = driver.findElement(byElem);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
	}
	
	public Boolean isSelected(By byElem) {
		WebElement element = driver.findElement(byElem);
		return element.isSelected();
	}

}
