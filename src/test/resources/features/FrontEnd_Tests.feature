Feature: Front End Testing Scenarios to test the borrowing calculator

  @test
  Scenario: Validate the borrowing estimate
    Given I want to validate the borrowing estimate
    When I select or enter the following values
      | applicationType | numberOfDependents | propertyType    | yourIncomeBeforeTax | yourOtherIncome | livingExpenses | currentHomeLoanRepayments | otherLoanRepayments | otherCommitments | totalCreditCardLimits |
      | Single          |                  0 | Home to live in |               80000 |           10000 |            500 |                         0 |                 100 |                0 |                 10000 |
    And I click the <buttonName> button
      | buttonName                       |
      | Work out how much I could borrow |
    Then I validate the <borrowingEstimate>
      | borrowingEstimate |
      | $467,000          |

  @test
  Scenario: Validate that the start over button clears the form
    Given I want to validate the borrowing estimate
    When I select or enter the following values
      | applicationType | numberOfDependents | propertyType    | yourIncomeBeforeTax | yourOtherIncome | livingExpenses | currentHomeLoanRepayments | otherLoanRepayments | otherCommitments | totalCreditCardLimits |
      | Single          |                  0 | Home to live in |               80000 |           10000 |            500 |                         0 |                 100 |                0 |                 10000 |
    And I click the <buttonName> button
      | buttonName                       |
      | Work out how much I could borrow |
    And I click the <buttonName> button
      | buttonName |
      | Start over |
    Then I validate that the form is cleared

  @test
  Scenario: Validate the message on entering Living Expenses as 1 and other fields as zero
    Given I want to validate the borrowing estimate
    When I select or enter the following values
      | applicationType | numberOfDependents | propertyType    | yourIncomeBeforeTax | yourOtherIncome | livingExpenses | currentHomeLoanRepayments | otherLoanRepayments | otherCommitments | totalCreditCardLimits |
      | Single          |                  0 | Home to live in |                   0 |               0 |              1 |                         0 |                   0 |                0 |                     0 |
    And I click the <buttonName> button
      | buttonName                       |
      | Work out how much I could borrow |
    Then I validate the <message>
      | Message                                                                                                                                                         |
      | Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641. |
