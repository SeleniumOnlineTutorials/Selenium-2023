package com.demoqa.driverUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Driverutils {
    public WebDriver driver=null;

    public WebDriver launchApplication(){
        String browser="chrome";
        if(browser.equalsIgnoreCase("chrome")){
               System.setProperty("webdriver.chrome.driver", "D:\\Selenium Jars\\chrome 108\\chromedriver.exe");
               driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.firefox.driver", "D:\\Selenium Jars\\chrome 108\\chromedriver.exe");
            driver = new FirefoxDriver();
        }

        // Maximize the window
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        //launch the application
        driver.get("https://demoqa.com/");
        return driver;
    }
}
