package com.qa.util;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtill extends Testbase {
	
	
	static int PAGE_LOAD_TIMEOUT = 60;
	static int IMPLICIT_WAIT = 60;
	
	
	public static void waitForElement(WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public static void clearTextField(WebElement element)
	{
		element.clear();
	}
	
	public static void clickWebelement(WebElement element) 
	{
	  try 
	  {
		boolean elementIsClickable = element.isEnabled();
		while (elementIsClickable) 
		{
			element.click();
		}
	  } 
	  catch (Exception e) 
	  {
		  System.out.println("Element is not enabled");
		  e.printStackTrace();
	   }
	}
	
	public static boolean checkAlert_Accept()
	{
	  try 
	  {
		Alert a = driver.switchTo().alert();
		String str = a.getText();
		a.accept();
		return true;
      } 
	  catch (Exception e) 
	  {
		System.out.println("No allert");
		return false;
       }
	}
	
	public static boolean checkAlert_Dismiss() 
	{
	  try 
	  {
		Alert a = driver.switchTo().alert();
		String str = a.getText();
		a.dismiss();
		return true;

	   } 
	  catch (Exception e) 
	  {

		System.out.println("No allert");
		return false;
      }
	}
	
	public static void checkbox_Checking(WebElement checkbox) 
	{
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true)
		{
		   System.out.println("Checkbox is already checked");
		} 
		else
		{
		   checkbox.click();
		   System.out.println("Checkbox checked");
		}
	}
	
	public static void radiobutton_Select(WebElement Radio) 
	{
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) 
		{
			System.out.println("RadioButton is already checked");
		}
		else 
		{
		    Radio.click();
		}
	}
	
	// Unchecking
	public static void checkbox_Unchecking(WebElement checkbox) 
	{
	   boolean checkstatus;
	   checkstatus = checkbox.isSelected();
	   if (checkstatus == true) 
	   {
	      checkbox.click();
	      System.out.println("Checkbox is unchecked");
	   } 
	   else 
	   {
		   System.out.println("Checkbox is already unchecked");
	   }
	}
	
	public static void radioButton_Deselect(WebElement Radio) 
	{
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) 
		{
		   Radio.click();
		   System.out.println("Radio Button is deselected");
		} 
		else 
		{
			System.out.println("Radio Button was already Deselected");
		}
	}
	
	public static void clickCheckboxFromList(String xpathOfElement,String valueToSelect)
	{
		List<WebElement> lst = driver.findElements(By.xpath(xpathOfElement));
		for (int i = 0; i < lst.size(); i++) 
		{
			List<WebElement> dr = lst.get(i).findElements(By.tagName("cc"));
		    for (WebElement f : dr) 
		    {
		    	System.out.println("value in the list : ” + f.getText()");
			    if (valueToSelect.equals(f.getText())) 
			    	{
			    	  f.click();
			          break;
			        }
		    }
		}
	}

		
}
