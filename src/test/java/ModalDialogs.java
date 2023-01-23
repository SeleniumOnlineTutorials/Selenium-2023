import com.demoqa.driverUtils.Driverutils;
import com.demoqa.pages.HomePage;
import com.demoqa.utils.ReadExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ModalDialogs {

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
            hp.navigateToMenu("Alerts, Frame & Windows", "Modal Dialogs");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showSmallModal")));

            WebElement smallModal=driver.findElement(By.id("showSmallModal"));
            smallModal.click();

            WebElement we=driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-sm']"));
            wait.until(ExpectedConditions.visibilityOf(we));

            we=driver.findElement(By.xpath("//div[@class='modal-body']"));
            System.out.println(we.getText());

            we=driver.findElement(By.id("closeSmallModal"));
            we.click();

            we=driver.findElement(By.id("showLargeModal"));
            wait.until(ExpectedConditions.visibilityOf(we));
            we.click();

            we=driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']"));
            wait.until(ExpectedConditions.visibilityOf(we));

            we=driver.findElement(By.xpath("//div[@class='modal-body']/p"));
            System.out.println(we.getText());

            we=driver.findElement(By.id("closeLargeModal"));
            we.click();




        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            driver.close();
            driver.quit();
        }
    }
}
