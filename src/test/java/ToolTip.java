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

public class ToolTip {
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
            hp.navigateToMenu("Widgets", "Tool Tips");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toolTipButton"))));
            act.moveToElement(driver.findElement(By.id("toolTipButton"))).build().perform();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='buttonToolTip']/div[@class='tooltip-inner']"))));
            if(driver.findElement(By.xpath("//div[@id='buttonToolTip']/div[@class='tooltip-inner']")).getText().equalsIgnoreCase("you hovered over the button"))
                System.out.println("Tool tip is displayed");
            else throw new Exception("Tool tip isnot hovered properly");

            js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//a[text()='Contrary']")));
            act.moveToElement(driver.findElement(By.xpath("//a[text()='Contrary']"))).build().perform();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='contraryTexToolTip']/div[@class='tooltip-inner']"))));
            if(driver.findElement(By.xpath("//div[@id='contraryTexToolTip']/div[@class='tooltip-inner']")).getText().equalsIgnoreCase("you hovered over the contrary"))
                System.out.println("tool tip for contrary is displayed");
            else throw new Exception("Tool tip is not hoverd properly on contrary");

        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            driver.close();
            driver.quit();
        }
    }
}
