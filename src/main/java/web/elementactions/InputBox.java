package web.elementactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputBox {

WebDriver driver;
	
	public InputBox(WebDriver driver) {
		this.driver = driver;
	}
	
	public void type(String text, By byelem) {
		WebElement inputBox = driver.findElement(byelem);
		inputBox.click();
		inputBox.clear();
		inputBox.sendKeys(text);
	}
	
	public String getInputBoxValue(By byElem) {
		WebElement inputBox = driver.findElement(byElem);
		return inputBox.getAttribute("value");
	}

}
