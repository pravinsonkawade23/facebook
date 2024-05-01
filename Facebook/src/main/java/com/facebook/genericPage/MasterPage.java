package com.facebook.genericPage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MasterPage {

	public static WebDriver driver;
	public Properties prop;
	public Properties loc;
	public Properties td;

	// constructor
	public MasterPage() throws Exception {

		// configuring properties file
		FileInputStream fis1 = new FileInputStream(
				System.getProperty("user.dir") + "\\repository\\configuration.properties");
		prop = new Properties();
		prop.load(fis1);

		FileInputStream fis2 = new FileInputStream(
				System.getProperty("user.dir") + "\\repository\\locators.properties");
		loc = new Properties();
		loc.load(fis2);
		System.out.println("hello");
		
		FileInputStream fis3 = new FileInputStream(
				System.getProperty("user.dir") + "\\repository\\testData.properties");
		td = new Properties();
		td.load(fis3);
		
		// initiating browser
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void click(String xpathKey) {

		driver.findElement(By.xpath(loc.getProperty(xpathKey))).click();
	}

	public void enterData(String xpathKey, String testData) {
		driver.findElement(By.xpath(loc.getProperty(xpathKey))).sendKeys(td.getProperty(testData));
	}

	public void clearData(String xpathKey) {
		driver.findElement(By.xpath(loc.getProperty(xpathKey))).clear();
	}

	public void moveToElement(String xpathKey) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(loc.getProperty(xpathKey)))).build().perform();
	}

	public void clickListElement(String xpathKey, String testData) {
		List<WebElement> radios = driver.findElements(By.xpath(loc.getProperty(xpathKey)));
		for(int i=0; i<radios.size(); i++) {
			if(radios.get(i).getText().equalsIgnoreCase(td.getProperty(testData))) {
				radios.get(i).click();
			}
		}
	}
	
	public void selectDropdownValue(String xpathKey, String testData1, String testData2) {
		WebElement drdo = driver.findElement(By.xpath(loc.getProperty(xpathKey)));
		Select sel= new Select(drdo);
		sel.selectByVisibleText(td.getProperty(testData1));
		System.out.println(sel.getFirstSelectedOption().getText());		
	}

}
