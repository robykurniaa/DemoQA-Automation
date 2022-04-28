package com.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoqa.drivers.DriverSingleton;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonTypeInfo.Id;


public class TextBoxPage {
	
	private WebDriver driver;

	public TextBoxPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "close-fixedban")
	WebElement closeAds;
	
	@FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(1)")
	WebElement btnElements;
	@FindBy(id = "item-0")
	WebElement btnTextBox;
	@FindBy(id = "userName")
	WebElement inputUsername;
	@FindBy(id = "userEmail")
	WebElement inputEmail;
	@FindBy(id = "currentAddress")
	WebElement inputCurrentAddress;
	@FindBy(id = "permanentAddress")
	WebElement inputPermanentAddress;
	@FindBy(id = "name")
	WebElement textSubmitTextBox;
	@FindBy(id = "submit")
	WebElement btnSubmit;
	
	public void clickelements() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnElements);
		btnElements.click();
		load(1);
	}
	
	public void goToTextBox() {
		btnTextBox.click();
	}
	
	public void inputTextBox() {
		inputUsername.sendKeys("Robyyyy");
		inputEmail.sendKeys("roby@gmail.com");
		inputCurrentAddress.sendKeys("Majalaya");
		inputPermanentAddress.sendKeys("Bandung");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnSubmit);
		btnSubmit.click();
		load(3);
	}
	
	public String textTextBox() {
		return textSubmitTextBox.getText();
	}
	
	
	
	public void load(int detik) {
		try {
			Thread.sleep(detik * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
