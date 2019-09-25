package stepdefinitions;

import java.util.HashMap;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import pageobjects.MuchBorrowPage;
import utils.DataUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UiStepDefinitions {

	MuchBorrowPage muchBorrowPage = new MuchBorrowPage();
	
	@Given("^I want to validate the borrowing estimate$")
	public void i_want_to_validate_the_borrowing_estimate() throws Throwable {
	
	}
	
	@When("^I select or enter the following values$")
	public void i_select_or_enter_the_following_values(DataTable dataTable) throws Throwable {
		HashMap<String,String> data = DataUtil.convertDataTableToMap(dataTable).get(0);
		String applicationType = data.get("applicationType");
		String numberOfDependents = data.get("numberOfDependents");
		String propertyType = data.get("propertyType");
		String yourIncomeBeforeTax = data.get("yourIncomeBeforeTax");
		String yourOtherIncome = data.get("yourOtherIncome");
		String livingExpenses = data.get("livingExpenses");
		String currentHomeLoanRepayments = data.get("currentHomeLoanRepayments");
		String otherLoanRepayments = data.get("otherLoanRepayments");
		String otherCommitments = data.get("otherCommitments");
		String totalCreditCardLimits = data.get("totalCreditCardLimits");
		muchBorrowPage.enterValuesInBorrowingCalculatorPage(applicationType,numberOfDependents,propertyType,yourIncomeBeforeTax,yourOtherIncome,livingExpenses,currentHomeLoanRepayments,otherLoanRepayments,otherCommitments,totalCreditCardLimits);
	}

	@When("^I click the <buttonName> button$")
	public void i_click_the_buttonName_button(DataTable dataTable) throws Throwable {
		HashMap<String,String> data = DataUtil.convertDataTableToMap(dataTable).get(0);
		String buttonName = data.get("buttonName");
		muchBorrowPage.clickButton(buttonName);
	}
	
	@Then("^I validate the <borrowingEstimate>$")
	public void i_validate_the_borrowingEstimate(DataTable dataTable) throws Throwable {
		HashMap<String,String> data = DataUtil.convertDataTableToMap(dataTable).get(0);
		String borrowingEstimate = data.get("borrowingEstimate");
		String borrowingEstimateActual = muchBorrowPage.getMessage("borrowingEstimate");
		Assert.assertEquals("Borrowing Estimate displayed is not correct", borrowingEstimate,borrowingEstimateActual);
	}

	@Then("^I validate that the form is cleared$")
	public void i_validate_that_the_form_is_cleared() throws Throwable {
		String yourIncomeBeforeTaxActual = muchBorrowPage.getActualValueInputBoxFromBorrowingCalculatorPage("Your Income Before Tax");
		String yourOtherIncomeActual = muchBorrowPage.getActualValueInputBoxFromBorrowingCalculatorPage("Your Other Income");
		String livingExpensesActual = muchBorrowPage.getActualValueInputBoxFromBorrowingCalculatorPage("Living Expenses");
		String currentHomeLoanRepaymentsActual = muchBorrowPage.getActualValueInputBoxFromBorrowingCalculatorPage("Current Home Loan Repayments");
		String otherLoanRepaymentsActual = muchBorrowPage.getActualValueInputBoxFromBorrowingCalculatorPage("Other Loan Repayments");
		String otherCommitmentsActual = muchBorrowPage.getActualValueInputBoxFromBorrowingCalculatorPage("Other Commitments");
		String totalCreditCardLimitsActual = muchBorrowPage.getActualValueInputBoxFromBorrowingCalculatorPage("Total Credit Card Limits");
		String numberOfDependentsActual = muchBorrowPage.getActualValueDropDownFromBorrowingCalculatorPage();
		Boolean applicationTypeActual = muchBorrowPage.getActualValueLabelFromBorrowingCalculatorPage("Application Type");
		Boolean propertyTypeActual = muchBorrowPage.getActualValueLabelFromBorrowingCalculatorPage("Property Type Type");
		Assert.assertTrue("Application Type is not reset after clicking Start over", applicationTypeActual);
		Assert.assertEquals("Number of dependents is not reset after clicking Start over", "0",numberOfDependentsActual);
		Assert.assertTrue("Property Type is not reset after clicking Start over", propertyTypeActual);
		Assert.assertEquals("Your Income Before Tax is not reset after clicking Start over", "0",yourIncomeBeforeTaxActual);
		Assert.assertEquals("Your Other Income is not reset after clicking Start over", "0",yourOtherIncomeActual);
		Assert.assertEquals("Living Expenses is not reset after clicking Start over", "0",livingExpensesActual);
		Assert.assertEquals("Current Home Loan Repayments is not reset after clicking Start over", "0",currentHomeLoanRepaymentsActual);
		Assert.assertEquals("Other Loan Repayments", "0",otherLoanRepaymentsActual);
		Assert.assertEquals("Other Commitments", "0",otherCommitmentsActual);
		Assert.assertEquals("Total Credit Card Limits", "0",totalCreditCardLimitsActual);
	}
	
	@Then("^I validate the <message>$")
	public void i_validate_the_message(DataTable dataTable) throws Throwable {
		HashMap<String,String> data = DataUtil.convertDataTableToMap(dataTable).get(0);
		String message = data.get("Message");
		String messageActual = muchBorrowPage.getMessage("Message");
		Assert.assertEquals("Correct message is not displayed", message, messageActual);
	}
}
