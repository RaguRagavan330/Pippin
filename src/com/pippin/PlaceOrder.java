package com.pippin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

import com.base.BaseCla;
import com.pages.LoginPage;
import com.pages.LogoutPage;
import com.pages.OrderDetails;
import com.pages.PlaOrd;
import com.pages.PlaceNewOrder;


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
		String url = properties.getProperty("url");
		String keyValue = properties.getProperty("key");
		String user = properties.getProperty("username");
		String pass = properties.getProperty("password");
		
		if(chromeBrowser.equalsIgnoreCase("chrome"))
			{
				System.setProperty(keyValue, driverLocationchrome);
				driver = new ChromeDriver();
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
		//File path
		String file = "E:\\JavaSelenium\\DineshGanesan\\PippinTech\\Pdf\\File1.pdf";
		
		//To used to convert normal string to normal text\Data transfered
		StringSelection selection = new StringSelection(file);
		
		//Select the clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		//Select the file from window for uploading.
		//So we are using Robot class. Because we won't automate windows based application is selenium
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_V);		
		r1.keyRelease(KeyEvent.VK_V);
		r1.keyRelease(KeyEvent.VK_CONTROL);		
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
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
