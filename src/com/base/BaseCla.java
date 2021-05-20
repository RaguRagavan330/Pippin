package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseCla {
	
	public static WebDriver driver;
		
	public static WebDriver getDriver()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\JavaSelenium\\DineshGanesan\\AdactIn\\driver\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		 
		 return driver; 
		 
	}
	public static void loadUrl(String url)
	{
		driver.get(url);
	}
	
	public static void windowMax()
	{
		driver.manage().window().maximize();
	}
	
	public static void title()
	{
		String text = driver.getTitle();
		System.out.println(text);		
	}
	
	public static void gText(WebElement ele)
	{
		String text1 = ele.getText();
		System.out.println(text1);
	}
	
	public static void sendKeyMethod(WebElement ele, String value)
	{
		ele.sendKeys(value);
	}
	
	public static void btn(WebElement ele)
	{
		ele.click();
	}
	public static void getUrl()
	{
		driver.getCurrentUrl();
	}
	
	public static void getAttributeValue(WebElement ele, String value)
	{
		String text2 = ele.getAttribute(value);
		System.out.println(text2);
	}
	
	public static void close()
	{
		driver.close();
	}
	
	public void quit()
	{
		driver.quit();
	}
	
	public static void dradAndDropMethod(WebElement source, WebElement target)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
			
	}
	public static void mouseHover(WebElement hover)
	{
		Actions a = new Actions(driver);
		a.moveToElement(hover).perform();
	}
	
	public static void doubleClickMethod(WebElement dClick)
	{
		Actions a = new Actions(driver);
		a.doubleClick(dClick).perform();
	}
	
	public static void rClick(WebElement rClick)
	{
		Actions a = new Actions(driver);
		a.contextClick(rClick).perform();
	}
	
	public static void selectByValueMethod(WebElement ele, String Value)
	{
		Select s = new Select(ele);
		s.selectByValue(Value);
	}
	
	public static void selectByVisibleTextMethod(WebElement ele, String Value)
	{
		Select s = new Select(ele);
		s.selectByVisibleText(Value);
	}
	
	public static void selectByIndexMethod(WebElement ele, int num)
	{
		Select s = new Select(ele);
		s.selectByIndex(num);
	}
	
	public static void getFirstSelectOption(WebElement ele)
	{
		Select s = new Select(ele);
		s.getFirstSelectedOption();
		
	}
	
	public static void deSelectByValueMethod(WebElement ele, String Value)
	{
		Select s = new Select(ele);
		s.selectByValue(Value);
	}
	
	public static void deSelectByVisibleTextMethod(WebElement ele, String Value)
	{
		Select s = new Select(ele);
		s.selectByVisibleText(Value);
	}
	
	public static void deSelectByIndexMethod(WebElement ele, int num)
	{
		Select s = new Select(ele);
		s.selectByIndex(num);
	}
	
	public static void naviTo(String url)
	{
		driver.navigate().to(url);
	}
	
	public static void naviBack()
	{
		driver.navigate().back();
	}
	
	public static void naviRefresh()
	{
		driver.navigate().refresh();
	}
	
	public static void naviForward()
	{
		driver.navigate().forward();
	}
	
	public static void frameId(String id)
	{
		driver.switchTo().frame(id);
	}
	
	public static void frameName(String name)
	{
		driver.switchTo().frame(name);
	}
	
	public static void defaultFrame()
	{
		driver.switchTo().defaultContent();
	}
	
	public static void frameElement(WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
	public static void frameIndex(int num)
	{
		driver.switchTo().frame(num);
	}
	
	public static void windowUrl(String url)
	{
		driver.switchTo().window(url);
	}
	
	public static void windowTitle(String title)
	{
		driver.switchTo().window(title);
	}
	
	public static void windowsId(String parentId)
	{
		driver.switchTo().window(parentId);
	}
	
	public static void defaultWindow()
	{
		driver.switchTo().defaultContent();
	}
	
	public static void screenShot(String target) throws IOException
	{
		TakesScreenshot tk = (TakesScreenshot) driver;
		
		File s = tk.getScreenshotAs(OutputType.FILE);
		File d = new File(target);
		FileUtils.copyFile(s, d);
	}
	
	public static void impWait()
	{
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	public static void loadTime()
	{
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}
	
	public static void waitTime() throws InterruptedException
	{
		Thread.sleep(8000);
	}
	public static void jExecuteClick(WebElement ele)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
	}
	
	
	public static void rDown() throws AWTException
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	
	public static void rEnter() throws AWTException
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void currentDateAndTime()
	{
		Date d = new Date();
		System.out.println(d);
	}
	
}




