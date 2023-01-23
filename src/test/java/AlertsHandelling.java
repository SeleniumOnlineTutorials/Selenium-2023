import com.demoqa.driverUtils.Driverutils;
import com.demoqa.pages.HomePage;
import com.demoqa.utils.ReadExcelFile;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class AlertsHandelling {

    public static void main(String[] args) {
        WebDriver driver=null;
        ReadExcelFile data=new ReadExcelFile();
        ArrayList<ArrayList<String>> al=data.readData();
        Driverutils obj=new Driverutils();
        driver=obj.launchApplication();
        WebDriverWait wait=new WebDriverWait(driver,50);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HomePage hp=new HomePage(driver);
        try {
          hp.navigateToMenu("Alerts, Frame & Windows", "Alerts");
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertButton")));
          driver.findElement(By.id("alertButton")).click();
          Alert alert=driver.switchTo().alert();
          System.out.println(alert.getText());
            Thread.sleep(2000);
          alert.accept();// click on OK
          driver.switchTo().defaultContent();
          driver.findElement(By.id("timerAlertButton")).click();
          Thread.sleep(5000);
            alert=driver.switchTo().alert();
            System.out.println(alert.getText());
            Thread.sleep(2000);
            alert.accept();
            driver.switchTo().defaultContent();
            //confrim box
            driver.findElement(By.id("confirmButton")).click();
            alert=driver.switchTo().alert();
            System.out.println(alert.getText());
            Thread.sleep(2000);
            alert.dismiss(); // click on cancel

            driver.switchTo().defaultContent();
            //confrim box
            driver.findElement(By.id("confirmButton")).click();
            alert=driver.switchTo().alert();
            System.out.println(alert.getText());
            Thread.sleep(2000);
            alert.accept(); // click on ok


            driver.switchTo().defaultContent();
            //Prompt box
            js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("promtButton")));
            driver.findElement(By.id("promtButton")).click();
            alert=driver.switchTo().alert();
            System.out.println(alert.getText());
            Thread.sleep(2000);
            alert.sendKeys("this is test"); // Enetering data to the prompt popup
            Thread.sleep(2000);
            alert.accept();


        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.close();
            driver.quit();
        }
        }
}
