package com.pippin;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseCla;
import com.pages.LoginPage;
import com.pages.LogoutPage;
import com.pages.OrderDetails;
import com.pages.PlaOrd;
import com.pages.PlaceNewOrder;
import com.upload.UploadFile;


public class PlaceOrder extends BaseCla {
	
	public static Properties properties = null;
	
	public static void main(String args[]) throws AWTException, InterruptedException, IOException
	{
		//Browser launching
		//getDriver();
		
		//Config Properties
		FileInputStream stream = new FileInputStream("config.properties");		
		properties = new Properties();		
		properties.load(stream);
		
		String chromeBrowser = properties.getProperty("chromebrowser");
		String driverLocationchrome = properties.getProperty("driverLocationChrome");
		String fireFoxBrowser = properties.getProperty("firefoxbrowser");
		String driverLocationff = properties.getProperty("driverLocationFireFox");
		
		
		String url = properties.getProperty("url");
		String keyChrome = properties.getProperty("keychrome");
		String keyFire = properties.getProperty("keyFire");
		String user = properties.getProperty("username");
		String pass = properties.getProperty("password");
		
		if(chromeBrowser.equalsIgnoreCase("chrome"))
			{
				System.setProperty(keyChrome, driverLocationchrome);
				driver = new ChromeDriver();
				driver.get(url);
			}
		else if(fireFoxBrowser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(keyFire, driverLocationff);
			driver = new FirefoxDriver();
			driver.get(url);
		}
		
		//Maximize
		windowMax();
		//Login Page
		LoginPage l = new LoginPage();
		sendKeyMethod(l.getTextUser(), user);
		sendKeyMethod(l.getTextPass(), pass);
		btn(l.getLoginBtn());
		
		//Place Order
		PlaOrd p = new PlaOrd();
		impWait();
		jExecuteClick(p.getPlaceOrder());
		gText(p.getPlaceOrder());
		
		//Place New Order
		PlaceNewOrder n = new PlaceNewOrder();
		jExecuteClick(n.getFullSearch());
		gText(n.getFullSearch());
		sendKeyMethod(n.getOwnerSeller(), "Ragunath Ragavan");
		waitTime();
		sendKeyMethod(n.getAddress(), "3485 Wineville");
		waitTime();
		for(int i=0; i<2; i++)
			{			
				rDown();
			}
		rEnter();
		sendKeyMethod(n.getClientReference(), "Ragunath Ragavan_04_02_1992");
		jExecuteClick(n.getUpload());
		waitTime();
		
		UploadFile u = new UploadFile();
		u.fileUpload("E:\\JavaSelenium\\DineshGanesan\\PippinTech\\Pdf\\File1.pdf");
		
		
		//jExecuteClick(n.getUpload());
		WebDriverWait wait1 = new WebDriverWait(driver, 100);
		WebElement load1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary css-bnepv4']")));
		load1.click();
		waitTime();
		u.fileUpload("E:\\JavaSelenium\\DineshGanesan\\PippinTech\\Pdf\\File2.pdf");
		
		WebDriverWait wait2 = new WebDriverWait(driver, 100);
		WebElement load2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary css-bnepv4']")));
		load2.click();
		waitTime();
		u.fileUpload("E:\\JavaSelenium\\DineshGanesan\\PippinTech\\Pdf\\File3.pdf");
		
		//Delete file
		WebDriverWait wait3 = new WebDriverWait(driver, 100);
		WebElement deleteFile2 = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[contains(text(), 'delete')])[2]")));
		jExecuteClick(deleteFile2);
		waitTime();
		WebElement confirm1 = driver.findElement(By.xpath("//input[@class='btn btn-primary btn-block']"));
		jExecuteClick(confirm1);
		
		//Delete file
		WebDriverWait wait4 = new WebDriverWait(driver, 100);
		WebElement deleteFile1 = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[contains(text(), 'delete')])[1]")));
		jExecuteClick(deleteFile1);
		waitTime();
		WebElement confirm2 = driver.findElement(By.xpath("//input[@class='btn btn-primary btn-block']"));
		jExecuteClick(confirm2);
		//Click Continue
		waitTime();
		jExecuteClick(n.getcontBtn());
		//To click terms and conditions
		jExecuteClick(n.getTermsCon());
		jExecuteClick(n.getSubmit());
		
		//Order Details
		OrderDetails o = new OrderDetails();
		String name = o.getOwName().getAttribute("value");
		System.out.println(name);
		String orNum = o.getOrderNumber().getAttribute("value");
		System.out.println(orNum);
		jExecuteClick(o.getMessage());
		jExecuteClick(o.getTextArea());
		Date d = new Date();
		sendKeyMethod(o.getTextArea(), name + "\n" + orNum + "\n" + d);
		jExecuteClick(o.getSend());
		
		//Logout the page
		LogoutPage log = new LogoutPage();		
		jExecuteClick(log.getMenu());
		for(int i=0; i<3; i++)
		{
			rDown();
		}
		rEnter();
		close();
	}

	
}
