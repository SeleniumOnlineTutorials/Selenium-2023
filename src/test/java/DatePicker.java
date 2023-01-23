import com.demoqa.driverUtils.Driverutils;
import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DatePicker {

    public static void main(String[] args) {
        WebDriver driver = null;
        Driverutils obj = new Driverutils();
        driver = obj.launchApplication();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        Wait fwait=new FluentWait(driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(3));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HomePage hp = new HomePage(driver);
        Actions act=new Actions(driver);
        Select sel=null;
        try {
            hp.navigateToMenu("Widgets", "Date Picker");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("datePickerMonthYear"))));
            driver.findElement(By.id("datePickerMonthYearInput")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='react-datepicker__month-container']")));
            sel=new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
            sel.selectByVisibleText("February");
          //  Thread.sleep(5000);
            sel=new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
            sel.selectByValue("2024");

            driver.findElement(By.xpath("//div[@class='react-datepicker__month']/div[4]/div[5]")).click();

            driver.findElement(By.id("dateAndTimePickerInput")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='react-datepicker__month-container']"))));
            //month
            driver.findElement(By.xpath("//span[@class='react-datepicker__month-read-view--down-arrow']")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='react-datepicker__month-dropdown']"))));
            driver.findElement(By.xpath("//div[text()='April']")).click();
            //year
            driver.findElement(By.xpath("//span[@class='react-datepicker__year-read-view--down-arrow']")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='react-datepicker__year-dropdown']"))));
            driver.findElement(By.xpath("//div[text()='2025']")).click();
            //select day
            driver.findElement(By.xpath("//div[@class='react-datepicker__month']/div[3]/div[4]")).click();
            Thread.sleep(5000);
            //select time
            act.moveToElement(driver.findElement(By.xpath("//ul[@class='react-datepicker__time-list']/li[text()='02:45']"))).click().build().perform();
            Thread.sleep(5000);


        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            driver.close();
            driver.quit();
        }
    }
}
