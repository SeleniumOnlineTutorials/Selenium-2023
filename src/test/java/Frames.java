import com.demoqa.driverUtils.Driverutils;
import com.demoqa.pages.HomePage;
import com.demoqa.utils.ReadExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Frames {

    public static void main(String[] args) {
        WebDriver driver = null;
        ReadExcelFile data = new ReadExcelFile();
        ArrayList<ArrayList<String>> al = data.readData();
        Driverutils obj = new Driverutils();
        driver = obj.launchApplication();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HomePage hp = new HomePage(driver);
        try {
            hp.navigateToMenu("Alerts, Frame & Windows", "Frames");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='framesWrapper']/div[1]")));
            System.out.println(driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]")).getText());

            driver.switchTo().frame(driver.findElement(By.id("frame1")));
            System.out.println(driver.findElement(By.id("sampleHeading")).getText());

            driver.switchTo().defaultContent();

            js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.id("frame2")));
            driver.switchTo().frame(driver.findElement(By.id("frame2")));
            System.out.println(driver.findElement(By.id("sampleHeading")).getText());

            hp.navigateToMenu("Alerts, Frame & Windows", "Nested Frames");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='framesWrapper']/div[1]")));

            driver.switchTo().frame(driver.findElement(By.id("frame1")));
            System.out.println(driver.findElement(By.xpath("//body")).getText());
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
            System.out.println(driver.findElement(By.xpath("//p")).getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            driver.close();
            driver.quit();
        }
    }
}
