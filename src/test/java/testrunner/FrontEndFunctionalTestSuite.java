package testrunner;

import init.UiInit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources"},
glue = "stepdefinitions",
plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json","html:target/cucumber-reports"},
tags = {"@test"}
		)

public class FrontEndFunctionalTestSuite {

	static UiInit uiInit;
	
@BeforeClass
public static void setup(){
	uiInit = new UiInit();
	uiInit.init();
	}

@AfterClass
public static void cleanup() {
	uiInit.shutdownDriver();
}
}
