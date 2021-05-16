package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseCla;

public class LogoutPage extends BaseCla {
	
	public LogoutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='css-1v3vl3d']")
	private WebElement menu;
	

	public WebElement getMenu() {
		return menu;
	}

}
