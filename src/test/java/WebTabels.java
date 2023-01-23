import com.demoqa.driverUtils.Driverutils;
import com.demoqa.utils.ReadExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class WebTabels {

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
            wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
            for(int i=0;i<al.size();i++){
                System.out.println(al.get(i));
                ArrayList<String> li=al.get(i);
                    if(li.contains("Add")){
                        driver.findElement(By.id("addNewRecordButton")).click();
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
                        driver.findElement(By.id("firstName")).sendKeys(li.get(0));
                        driver.findElement(By.id("lastName")).sendKeys(li.get(1));
                        driver.findElement(By.id("userEmail")).sendKeys(li.get(2));
                        driver.findElement(By.id("age")).sendKeys(li.get(3));
                        driver.findElement(By.id("salary")).sendKeys(li.get(4));
                        driver.findElement(By.id("department")).sendKeys(li.get(5));
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
                        driver.findElement(By.id("submit")).click();
                        wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));

                    }
                    else if(li.contains("Delete")){
                        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//div[text()='"+li.get(0)+"']/following-sibling::div//span[@title='Delete']")));
                      driver.findElement(By.xpath("//div[text()='"+li.get(0)+"']/following-sibling::div//span[@title='Delete']")).click();
                     /* if(!driver.findElement(By.xpath("//div[text()='"+li.get(0)+"']")).isDisplayed())
                          System.out.println("Record deleted successfully");
                          else
                              throw new Exception("Record is not deleted");*/

                    }
                    else if(li.contains("Edit")){
                        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//div[text()='"+li.get(0)+"']/following-sibling::div//span[@title='Edit']")));
                        driver.findElement(By.xpath("//div[text()='"+li.get(0)+"']/following-sibling::div//span[@title='Edit']")).click();
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
                        driver.findElement(By.id("firstName")).clear();
                        driver.findElement(By.id("firstName")).sendKeys(li.get(0));
                        driver.findElement(By.id("lastName")).clear();
                        driver.findElement(By.id("lastName")).sendKeys(li.get(1));
                        driver.findElement(By.id("userEmail")).clear();
                        driver.findElement(By.id("userEmail")).sendKeys(li.get(2));
                        driver.findElement(By.id("age")).clear();
                        driver.findElement(By.id("age")).sendKeys(li.get(3));
                        driver.findElement(By.id("salary")).clear();
                        driver.findElement(By.id("salary")).sendKeys(li.get(4));
                        driver.findElement(By.id("department")).clear();
                        driver.findElement(By.id("department")).sendKeys(li.get(5));
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
                        driver.findElement(By.id("submit")).click();
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addNewRecordButton")));
                    }



            }

        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            driver.close();
            driver.quit();
        }


    }

    private static void navigateToMenu(WebDriver driver) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,50);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//div[@class='category-cards']//h5[text()='Elements']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-cards']//h5[text()='Elements']")));
        driver.findElement(By.xpath("//div[@class='category-cards']//h5[text()='Elements']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Web Tables']"))));
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[text()='Web Tables']")));
        driver.findElement(By.xpath("//span[text()='Web Tables']")).click();
    }
}
