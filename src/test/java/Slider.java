import com.demoqa.driverUtils.Driverutils;
import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Slider {
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
            hp.navigateToMenu("Widgets", "Slider");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='range-slider__wrap']"))));
            act.clickAndHold(driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']")))
                    .moveByOffset(30,0).build().perform();
        }catch(Exception e){

        }
    }
}
