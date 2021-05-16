package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseCla;

public class PlaceNewOrder extends BaseCla {
	
	public PlaceNewOrder()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Full Search']")
	private WebElement fullSearch;
	
	@FindBy(xpath="//input[@id='Property_First_Name']")
	private WebElement ownerSeller;
	
	@FindBy(xpath="//input[@id='search-box']")
	private WebElement address;
	
	@FindBy(xpath="//input[@id='Property_Order_Number']")
	private WebElement clientReference;
	
	@FindBy(xpath="//button[@class='btn btn-primary css-bnepv4']")
	private WebElement upload;
	
	@FindBy(xpath="//button[contains(text(), 'Continue')]")
	private WebElement contBtn;
	
	@FindBy(xpath="//input[@id='mat-checkbox-1-input']//parent::div")
	private WebElement termsCon;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement submit;

	public WebElement getFullSearch() {
		return fullSearch;
	}

	public WebElement getOwnerSeller() {
		return ownerSeller;
	}
	
	public WebElement getAddress() {
		return address;
	}

	public WebElement getClientReference() {
		return clientReference;
	}

	public WebElement getUpload() {
		return upload;
	}
	
	public WebElement getcontBtn() {
		return contBtn;
	}	

	public WebElement getTermsCon() {
		return termsCon;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	
	
	
	
	
	

}
