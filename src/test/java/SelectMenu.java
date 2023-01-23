import com.demoqa.driverUtils.Driverutils;
import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SelectMenu {
    public static void main(String[] args) {

        WebDriver driver = null;
        Driverutils obj = new Driverutils();
        driver = obj.launchApplication();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        Wait fwait = new FluentWait(driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(3));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HomePage hp = new HomePage(driver);
        Actions act = new Actions(driver);

        try {
            hp.navigateToMenu("Widgets", "Select Menu");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("withOptGroup"))));
            js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//div[text()='Select...']/parent::div//input")));
            driver.findElement(By.xpath("//div[text()='Select...']/parent::div//input")).sendKeys("R");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Red']"))));
            //js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//div[text()='Red']")));
            act.moveToElement(driver.findElement(By.xpath("//div[text()='Red']"))).click().build().perform();
           // driver.findElement(By.xpath("//div[text()='Red']")).click();

            Select se=new Select(driver.findElement(By.id("cars")));
            if(se.isMultiple()){
                se.selectByValue("volvo");
                se.selectByVisibleText("Saab");
                se.selectByIndex(3);

                se.deselectAll();
            }
            Thread.sleep(4000);

        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            driver.close();
            driver.quit();
        }

    }
}
