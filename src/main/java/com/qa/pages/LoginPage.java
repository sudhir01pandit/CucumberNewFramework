package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.util.Testbase;


public class LoginPage extends Testbase {
	
	
	@FindBy(xpath = "//span[text()='Sign In']")
	public WebElement signInLink;
	
	@FindBy(xpath="//input[@id='username']")
	public WebElement userNameTextField;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement passwordTextField;
	
	@FindBy(xpath="//button[@class='btn wb-btn-default center-block']")
	public WebElement signInButton;
	
	@FindBy(xpath="//span[@class='signout']")
	public WebElement signOutButton;
	
	@FindBy(xpath="//div[contains(@class,'alert alert-danger')]")
	public WebElement errormessage;
	
	

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void TapOnSignInLink() 
	{
		signInLink.click();
	}
	
	public void EnterUserNamePassword(String username, String password ) throws InterruptedException 
	{
		 userNameTextField.click();
		 Thread.sleep(2000);
		 userNameTextField.sendKeys(username);
		 passwordTextField.click();
		 Thread.sleep(2000);
		 passwordTextField.sendKeys(password);
		 signInButton.click();
	}
	
	public static String VerifyhomeScreentitle() throws InterruptedException 
	{
		Thread.sleep(8000);
		return driver.getTitle();
	}
	
	public static String VerifyErrorMessage() throws InterruptedException 
	{
		Thread.sleep(4000);
		String TxtBoxContent = driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger')]")).getText();
		System.out.println(TxtBoxContent);
		return TxtBoxContent;
	}
}
