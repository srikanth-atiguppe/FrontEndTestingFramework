package pageobjects;

import web.elementactions.Button;
import web.elementactions.DropDown;
import web.elementactions.Generic;
import web.elementactions.InputBox;
import web.elementactions.Text;
import web.elementactions.Wait;
import init.UiInit;

public class BasePage extends UiInit {
	Button button = new Button(driver);
	DropDown dropDown = new DropDown(driver);
	Generic generic = new Generic(driver);
	InputBox inputBox = new InputBox(driver);
	Text text = new Text(driver);
	Wait wait = new Wait(driver);
}
