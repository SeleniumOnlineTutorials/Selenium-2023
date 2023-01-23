import com.demoqa.driverUtils.Driverutils;
import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Menu {
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
            hp.navigateToMenu("Widgets", "Menu");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Main Item 2"))));

            act.moveToElement(driver.findElement(By.linkText("Main Item 2"))).build().perform();
                 act.moveToElement(driver.findElement(By.linkText("SUB SUB LIST »"))).build().perform();
                 act.moveToElement(driver.findElement(By.linkText("Sub Sub Item 2"))).build().perform();
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
