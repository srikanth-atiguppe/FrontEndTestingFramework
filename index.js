var reporter = require('cucumber-html-reporter');

var options = {
        theme: 'bootstrap',
        jsonFile: 'D:/Eclipse/FrontEndTestingFramework/target/cucumber-reports/Cucumber.json',
        output: 'D:/Eclipse/FrontEndTestingFramework/target/cucumber-reports/cucumber_report.html',
        reportSuiteAsScenarios: true,
        scenarioTimestamp: true,
        launchReport: true,
        metadata: {
            "Platform": "Windows 7",
            "Parallel": "Scenarios"
        }
    };

reporter.generate(options);