package web.elementactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	WebDriver driver;
	
	public DropDown(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectFromDropDownByText(String text, By byElem) {
		Select dropDown = new Select(driver.findElement(byElem));
		dropDown.selectByVisibleText(text);
	}
	
	public void selectFromDropDownByValue(String text, By byElem) {
		Select dropDown = new Select(driver.findElement(byElem));
		dropDown.selectByValue(text);
	}
	
	public String getSelectedValue(By byElem) {
		Select dropDown = new Select(driver.findElement(byElem));
		return dropDown.getFirstSelectedOption().getText();
	}
}
