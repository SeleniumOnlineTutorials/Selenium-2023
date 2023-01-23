import com.demoqa.driverUtils.Driverutils;
import com.demoqa.pages.HomePage;
import com.demoqa.utils.ReadExcelFile;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.function.Function;

public class AutoComplete {

    public static void main(String[] args) {
        WebDriver driver = null;
        Driverutils obj = new Driverutils();
        driver = obj.launchApplication();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        Wait fwait=new FluentWait(driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(3));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HomePage hp = new HomePage(driver);
        Actions act=new Actions(driver);
        try {
            hp.navigateToMenu("Widgets", "Auto Complete");
            WebElement we=wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver webDriver) {
                    return webDriver.findElement(By.id("autoCompleteContainer"));
                }
            });

            WebElement typeMultipleColorNames=driver.findElement(By.xpath("//input[@id='autoCompleteMultipleInput']"));
            WebElement singleInput=driver.findElement(By.id("autoCompleteSingleInput"));

            act.click(typeMultipleColorNames).build().perform();
           // act.keyDown(Keys.TAB).release().build().perform();
            typeMultipleColorNames.sendKeys("bl");


            WebElement e=wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver webDriver) {
                    return webDriver.findElement(By.xpath("//div[contains(@class,'auto-complete__menu-list auto-complete__menu-list--is-multi')]"));
                }
            });
            driver.findElement(By.xpath("//div[contains(@class,'auto-complete__menu-list auto-complete__menu-list--is-multi')]/div[1]")).click();

            act.click(typeMultipleColorNames).build().perform();
            // act.keyDown(Keys.TAB).release().build().perform();
            typeMultipleColorNames.sendKeys("Y");
            e=wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver webDriver) {
                    return webDriver.findElement(By.xpath("//div[contains(@class,'auto-complete__menu-list auto-complete__menu-list--is-multi')]"));
                }
            });
            driver.findElement(By.xpath("//div[contains(@class,'auto-complete__menu-list auto-complete__menu-list--is-multi')]/div[1]")).click();

            act.click(singleInput).build().perform();
            // act.keyDown(Keys.TAB).release().build().perform();
            singleInput.sendKeys("Wh");
            e=wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver webDriver) {
                    return webDriver.findElement(By.xpath("//div[contains(@class,'auto-complete__menu-list')]"));
                }
            });
            act.moveToElement( driver.findElement(By.xpath("//div[contains(@class,'auto-complete__menu-list')]/div[1]"))).click().build().perform();

            Thread.sleep(3000);

        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            driver.close();
            driver.quit();
        }
    }
}
