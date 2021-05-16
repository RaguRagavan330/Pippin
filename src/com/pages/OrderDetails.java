package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseCla;

public class OrderDetails extends BaseCla {
	
	public OrderDetails()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Order_ID']")
	private WebElement orderNumber;
	
	@FindBy(xpath="//input[@id='Property_Name']")
	private WebElement owName;

	@FindBy(xpath="//input[@id='ordDetBtnSendMsg']")
	private WebElement message;
	
	@FindBy(xpath="//textarea[@id='msg-area']")
	private WebElement textArea;
	
	@FindBy(xpath="//input[@id='msgSend']")
	private WebElement send;
	
	
	public WebElement getOrderNumber() {
		return orderNumber;
	}

	public WebElement getOwName() {
		return owName;
	}
	
	public WebElement getMessage() {
		return message;
	}

	public WebElement getTextArea() {
		return textArea;
	}
	
	public WebElement getSend() {
		return send;
	}
	
	

}
