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

public class Accrodian {
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
            hp.navigateToMenu("Widgets", "Accordian");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("section1Heading")));

            WebElement loremIpsum=driver.findElement(By.xpath("//div[text()='What is Lorem Ipsum?']"));
            WebElement cameFrom=driver.findElement(By.xpath("//div[text()='Where does it come from?']"));
            WebElement useOfit=driver.findElement(By.xpath("//div[text()='Why do we use it?']"));

            WebElement loremIpsumContent=driver.findElement(By.xpath("//div[text()='What is Lorem Ipsum?']/following-sibling::div//p"));
            WebElement cameFromContent=driver.findElement(By.xpath("//div[text()='Where does it come from?']/following-sibling::div//p"));
            WebElement useOfItContent=driver.findElement(By.xpath("//div[text()='Why do we use it?']/following-sibling::div//p"));

            System.out.println(loremIpsumContent.getText());
            loremIpsum.click();
            wait.until(ExpectedConditions.invisibilityOf(loremIpsumContent));


            cameFrom.click();
            wait.until(ExpectedConditions.elementToBeClickable(cameFromContent));
            System.out.println(cameFromContent.getText());
            cameFrom.click();
            wait.until(ExpectedConditions.invisibilityOf(cameFromContent));

            useOfit.click();
            wait.until(ExpectedConditions.elementToBeClickable(useOfItContent));
            System.out.println(useOfItContent.getText());
            useOfit.click();
            wait.until(ExpectedConditions.invisibilityOf(useOfItContent));

        }
        catch (Exception e){

        }
        finally {
            driver.close();
            driver.quit();
        }


    }
}
