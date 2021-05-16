package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseCla;

public class PlaOrd extends BaseCla {
	
	public PlaOrd()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div//a//i//following-sibling::strong)[1]")
	private WebElement placeOrder;

	public WebElement getPlaceOrder() {
		return placeOrder;
	}
	
	

}
