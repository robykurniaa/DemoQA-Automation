package com.demoqa.glue.all;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.demoqa.config.AutomationFrameworkConfig;
import com.demoqa.drivers.DriverSingleton;
import com.demoqa.pages.TextBoxPage;
import com.demoqa.utils.ConfigurationProperties;
import com.demoqa.utils.Constants;
import com.demoqa.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class AllStepDefinition {
	
	private static WebDriver driver;
	private TextBoxPage textBox;
	
	
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportHadir.html");

	
	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		textBox = new TextBoxPage();
		extentTest = reports.startTest("Testing Menu Form Registration");
	}

	@AfterStep
	public void getResult(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			String screenshotPath = Utils.getScreenshot(driver, scenario.getName().replace(" ", "_"));
			extentTest.log(LogStatus.FAIL, "Screenshot:/n" + extentTest.addScreenCapture(screenshotPath));
		}
	}

	@After
	public void closeObject() {
		reports.endTest(extentTest);
		reports.flush();
	}

	@AfterAll
	public static void closeBrowser() {
//		driver.quit();
	}

	@Given("User access to Demo QA")
	public void user_access_to_demo_qa() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("User click elements")
	public void user_click_elements() {
	    textBox.clickelements();
	    extentTest.log(LogStatus.PASS, "User click elements");
	}

	@When("User click Text Box")
	public void user_click_text_box() {
	   textBox.goToTextBox();
	   extentTest.log(LogStatus.PASS, "User click Text Box");
	}
	
	@When("User Input Text Box")
	public void user_input_text_box() {
	   textBox.inputTextBox();
	}

	@Then("User success Input text box")
	public void user_success_input_text_box() {
	    String expect = "Name:";
	    assertEquals(expect, textBox.textTextBox());
	}

	
}