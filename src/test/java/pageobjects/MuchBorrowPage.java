package pageobjects;

import org.openqa.selenium.By;

public class MuchBorrowPage extends BasePage {

	public static By applicationTypeSingleLabel = By.xpath("//input[@id='borrow_type_home']");
	public static By numberOfDependentsDropdown = By.xpath("//select[@title='Number of dependants']");
	public static By borrowTypeHomeLabel = By.xpath("//input[@id='borrow_type_home']");
	public static By yourIncomeBeforeTaxInputBox = By.xpath("//input[@aria-labelledby='q2q1']");
	public static By yourOtherIncomeInputBox = By.xpath("//input[@aria-labelledby='q2q2']");
	public static By livingExpensesInputBox = By.xpath("//input[@aria-labelledby='q3q1']");
	public static By currentHomeLoanRepaymentsInputBox = By.xpath("//input[@aria-labelledby='q3q2']");
	public static By otherLoanRepaymentsInputBox = By.xpath("//input[@aria-labelledby='q3q3']");
	public static By otherCommitmentsInputBox = By.xpath("//input[@aria-labelledby='q3q4']");
	public static By totalCreditCardLimitsInputBox = By.xpath("//input[@aria-labelledby='q3q5']");
	public static By workOutHowMuchICouldBorrowButton = By.xpath("//button[contains(.,'Work out how much I could borrow')]");
	public static By borrowingAmountText = By.xpath("//span[@class='borrow__result__text__amount']");
	public static By startOverButton = By.xpath("//button[contains(.,'Start over')]");
	public static By borrowErrorText = By.xpath("//span[@class='borrow__error__text']");
	
	public void	enterValuesInBorrowingCalculatorPage(String applicationType,String numberOfDependents,String propertyType,String yourIncomeBeforeTax,String yourOtherIncome,String livingExpenses,String currentHomeLoanRepayments,String otherLoanRepayments,String otherCommitments,String totalCreditCardLimits) {
		if (applicationType.contentEquals("Single")) {
			generic.jsClick(applicationTypeSingleLabel);
		}
		else {
		//placeholder for Joint application type
		}
		
		dropDown.selectFromDropDownByText(numberOfDependents, numberOfDependentsDropdown);
		
		if (propertyType.contentEquals("Home to live in")) {
			generic.jsClick(borrowTypeHomeLabel);
		}
		else {
		//placeholder for Residential Investment Property Type
		}
		
		inputBox.type(yourIncomeBeforeTax, yourIncomeBeforeTaxInputBox);
		inputBox.type(yourOtherIncome, yourOtherIncomeInputBox);
		inputBox.type(livingExpenses, livingExpensesInputBox);
		inputBox.type(currentHomeLoanRepayments, currentHomeLoanRepaymentsInputBox);
		inputBox.type(otherLoanRepayments, otherLoanRepaymentsInputBox);
		inputBox.type(otherCommitments, otherCommitmentsInputBox);
		inputBox.type(totalCreditCardLimits, totalCreditCardLimitsInputBox);
	}

	public void clickButton(String buttonName) {
		if (buttonName.contentEquals("Work out how much I could borrow")) {
			button.click(workOutHowMuchICouldBorrowButton);
			wait.waitUntilVisible(applicationTypeSingleLabel);
		}
		else if (buttonName.contentEquals("Start over")) {
			button.click(startOverButton);
			wait.waitUntilVisible(applicationTypeSingleLabel);
		} 
	}
	
	public String getMessage(String textName) {
		if (textName.contentEquals("borrowingEstimate")) {
		return text.getText(borrowingAmountText);
		}
		else {
			return text.getText(borrowErrorText);
			}
	}
	
	public String getActualValueInputBoxFromBorrowingCalculatorPage(String fieldName) {
		if (fieldName.contentEquals("Your Income Before Tax")) {
			return inputBox.getInputBoxValue(yourIncomeBeforeTaxInputBox);
		}
		else if (fieldName.contentEquals("Your Other Income")) {
			return inputBox.getInputBoxValue(yourOtherIncomeInputBox);
		} 
		else if (fieldName.contentEquals("Living Expenses")) {
			return inputBox.getInputBoxValue(yourOtherIncomeInputBox);
		}
		else if (fieldName.contentEquals("Current Home Loan Repayments")) {
			return inputBox.getInputBoxValue(currentHomeLoanRepaymentsInputBox);
		}
		else if (fieldName.contentEquals("Other Loan Repayments")) {
			return inputBox.getInputBoxValue(otherLoanRepaymentsInputBox);
		}
		else if (fieldName.contentEquals("Other Commitments")) {
			return inputBox.getInputBoxValue(otherCommitmentsInputBox);
		}
		else {
			return inputBox.getInputBoxValue(totalCreditCardLimitsInputBox);
		}
			}
	
	public String getActualValueDropDownFromBorrowingCalculatorPage() {
		return dropDown.getSelectedValue(numberOfDependentsDropdown);
	}
	
	public Boolean getActualValueLabelFromBorrowingCalculatorPage(String fieldName) {
		if (fieldName.contentEquals("Application Type")) {
			return generic.isSelected(applicationTypeSingleLabel);
		}
		else {
			return generic.isSelected(borrowTypeHomeLabel);
		}
	}
	
}
