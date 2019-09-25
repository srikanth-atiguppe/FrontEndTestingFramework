# FrontEndTestingFramework
This is a Front End testing project template built against an borrowing calculator for a bank.

The borrowing calculator allows the user to get their borrowing estimate based on their earnings, expenses and other details.

## **Tech Stack**
The project has been built using Java, Maven, JUnit, Selenium WebDriver and the Gherkin - Behaviour Driven Development (BDD) approach has been used for writing the Front End tests using Cucumber. 

cucumber-html-reporter has been used for generating html reports from the output Cucumber JSON results file.

## **Pre-requisites**
* Install Java and set path
* Install Maven and set path
* Install Eclipse IDE
* Install Eclipse Plugins
  - Maven
  - Cucumber
* Ensure that Chrome is installed and the chromedriver that matches the Chrome version in your $PATH is downloaded and available in lib/drivers (The solution has been developed on a 32-bit Windows system, download the corresponding chromedriver version for your system)
* Ensure that Firefox is installed and geckodriver is downloaded and available in lib/drivers ((The solution has been developed on a 32-bit Windows system, download the corresponding geckodriver version for your system))
* Install Node.js (for cucumber-html-reporter)

## **Setup**
* Clone repository or download zip.
* Go to the project directory.
* Set the Browser to Chrome or Firefox in the test.properties file located in src/test/resources to run the tests on the desired browser. The solution can be extended for other desired browsers with minimal steps.
* Steps for cucumber-html-install
  * Install the following package through npm. 
      npm install cucumber-html-reporter --save-dev
  * Configure the options in index.js to reflect the path for the Cucumber result JSON file and the path where the output cucumber_report.html file will be generated.
  * Run the following code in a node.js script after Cucumber execution.
  * Various options can be configured for generating the reports. Please refer to https://github.com/gkushang/cucumber-html-reporter
  
## **Writing the tests**
* New tests can be written in src/test/resources/features with appropriate tags. 

## **Running the tests**
* Use "mvn test" or "mvn clean install" to run the tests from the command line. These will be used for CI/CD pipeline implementation.
* The test reports have been configured to be generated in HTML and JSON. Change the plugin in src/test/java/testrunner/FrontEndFunctionalTestSuite.java to generate XML reports. Alternatively, to change it from the command line, 
use mvn test -Dcucumber.options="–-plugin html:target/result-xml"
* A sample @test tag has been used in the feature files for execution. Please add and use relevant tags for your tests.

## **Reporting**
* The basic Cucumber HTML/JSON reports will be generated in the target/cucumber-reports folder. The type of report or path where the reports will be generated, can be configured from the plugin option in src/test/java/testrunner/FrontEndFunctionalTestSuite.java.
* cucumber-html-reporter has been used to generate pretty HTML reports from the Cucumber JSON report file.

## **Limitations**
* The cucumber-html-reporter needs to be run manually using a node.js script now. However, once the CI/CD pipeline is implemented, this manual step will not be required and it will be integrated with the pipeline.

## **Notes**
* If multiple test environments need to be setup, the URLs should be updated in the test.properties files and used in the Front End tests.
* The index.js file has been committed to the Git repository for review purpose. It will not be needed to be run manually and will be removed from the repository once the CI/CD pipeline is implemented.
