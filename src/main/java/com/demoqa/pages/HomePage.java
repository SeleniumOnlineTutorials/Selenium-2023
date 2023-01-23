package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriverWait wait=null;
    WebDriver driver=null;
    JavascriptExecutor js =null;
    public HomePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver,50);
       js= (JavascriptExecutor) driver;;
    }

   public void navigateToMenu(String concept, String option) {
        try {
            js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//div[@class='category-cards']//h5[text()='" + concept + "']")));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-cards']//h5[text()='" + concept + "']")));
            driver.findElement(By.xpath("//div[@class='category-cards']//h5[text()='" + concept + "']")).click();
        }catch(Exception e){e.printStackTrace();}
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='"+option+"']"))));
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[text()='"+option+"']")));
        driver.findElement(By.xpath("//span[text()='"+option+"']")).click();
    }
}
