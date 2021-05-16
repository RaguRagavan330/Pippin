package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseCla;

public class LoginPage extends BaseCla {

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email_Address")
	private WebElement textUser;
	
	@FindBy(id="User_Password")
	private WebElement textPass;
	
	@FindBy(id="loginBtnLogin")
	private WebElement LoginBtn;

	public WebElement getTextUser() {
		return textUser;
	}

	public WebElement getTextPass() {
		return textPass;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	
}
