import com.demoqa.driverUtils.Driverutils;
import com.demoqa.utils.ReadExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class BrowserWindows {
    public static void main(String[] args) {
        WebDriver driver=null;
        ReadExcelFile data=new ReadExcelFile();
        ArrayList<ArrayList<String>> al=data.readData();
        Driverutils obj=new Driverutils();
        driver=obj.launchApplication();
        WebDriverWait wait=new WebDriverWait(driver,50);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            navigateToMenu(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
            driver.findElement(By.id("tabButton")).click();

            String parentWindow =driver.getWindowHandle();
            System.out.println("parent window "+parentWindow);

            Set<String> windows=driver.getWindowHandles();
            Iterator it=windows.iterator();
            while (it.hasNext()){
                String childWindow=it.next().toString();
                    if (!childWindow.equalsIgnoreCase(parentWindow))
                    {
                        driver.switchTo().window(childWindow);
                        System.out.println(driver.getPageSource());
                        if(driver.getPageSource().contains("This is a sample page")){
                            System.out.println("Switched to new tab");
                        }
                        Thread.sleep(3000);
                    }

            }
            driver.close();
            Thread.sleep(3000);
           // driver.switchTo().defaultContent();
            driver.switchTo().window(parentWindow);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("windowButton")));
            driver.findElement(By.id("windowButton")).click();
            Thread.sleep(3000);
            windows.clear();

            windows=driver.getWindowHandles();
            it=windows.iterator();
            while (it.hasNext()){
                String childWindow=it.next().toString();
                if (!childWindow.equalsIgnoreCase(parentWindow))
                {
                    driver.switchTo().window(childWindow);
                    System.out.println(driver.getPageSource());
                    if(driver.getPageSource().contains("This is a sample page")){
                        System.out.println("Switched to new tab");
                    }
                    Thread.sleep(3000);
                }

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
           // driver.close();
            driver.quit();
        }
    }
    private static void navigateToMenu(WebDriver driver) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,50);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//div[@class='category-cards']//h5[text()='Elements']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-cards']//h5[text()='Alerts, Frame & Windows']")));
        driver.findElement(By.xpath("//div[@class='category-cards']//h5[text()='Alerts, Frame & Windows']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Browser Windows']"))));
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[text()='Browser Windows']")));
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();
    }
}
