import com.demoqa.driverUtils.Driverutils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {

    public static void main(String[] args) {
        WebDriver driver=null;
        Driverutils obj=new Driverutils();
        driver=obj.launchApplication();
        try {
           //resume the execution for 5 secs
           Thread.sleep(5000);

           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//div[@class='category-cards']//h5[text()='Elements']")));
           driver.findElement(By.xpath("//div[@class='category-cards']//h5[text()='Elements']")).click();
           //resume the execution for 5 secs
           Thread.sleep(15000);
            js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[text()='Radio Button']")));
           driver.findElement(By.xpath("//span[text()='Radio Button']")).click();
           //resume the execution for 5 secs
           Thread.sleep(5000);

           String opt="impressive";
           boolean flag=false;
           if(opt.equalsIgnoreCase("yes")){
               flag=  driver.findElement(By.id("yesRadio")).isEnabled();
               if(flag){
                   driver.findElement(By.xpath("//label[@for='yesRadio']")).click();
               }
               else
                   System.out.println("Radio button for "+opt+" is not enabled");
           }
           else if(opt.equalsIgnoreCase("no")){
               flag=  driver.findElement(By.id("noRadio")).isEnabled();
               if(flag){
                   driver.findElement(By.xpath("//label[@for='noRadio']")).click();
               }
               else
                   System.out.println("Radio button for "+opt+" is not enabled");
           }
           else if(opt.equalsIgnoreCase("impressive")){
               flag=  driver.findElement(By.id("impressiveRadio")).isEnabled();
               if(flag){
                   driver.findElement(By.xpath("//label[@for='impressiveRadio']")).click();
               }
               else
                   System.out.println("Radio button for "+opt+" is not enabled");
           }



       }catch(Exception e){
        e.printStackTrace();
       }
       finally{
           driver.close();
           driver.quit();
       }

    }
}
