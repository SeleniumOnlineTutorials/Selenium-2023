import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxes {
    public static void main(String[] args) throws Exception {


        System.setProperty("webdriver.chrome.driver","D:\\Selenium Jars\\chrome 108\\chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        // Maximize the window
        driver.manage().window().maximize();
        //launch the application
        driver.get("https://demoqa.com/");
        //resume the execution for 5 secs
        Thread.sleep(5000);
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//div[@class='category-cards']//h5[text()='Elements']")));
        driver.findElement(By.xpath("//div[@class='category-cards']//h5[text()='Elements']")).click();
        //resume the execution for 5 secs
        Thread.sleep(5000);
        driver.findElement(By.xpath(" //span[text()='Check Box']")).click();
        //resume the execution for 5 secs
        Thread.sleep(5000);
         //-->Home --->Documents --->Office --->private
        String option="Desktop::Notes";//"Documents::Office::Private"; //Desktop::Notes
        String category[]=option.split("::");
        if(!option.equalsIgnoreCase("home")){
            driver.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']")).click();
            //resume the execution for 2 secs
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='"+category[0]+"']/parent::label/preceding-sibling::button")).click();

            if(category.length==3){
                js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[text()='"+category[1]+"']/parent::label/preceding-sibling::button")));
                driver.findElement(By.xpath("//span[text()='"+category[1]+"']/parent::label/preceding-sibling::button")).click();
                js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[text()='"+category[2]+"']/parent::label/span[@class='rct-checkbox']")));
                driver.findElement(By.xpath("//span[text()='"+category[2]+"']/parent::label/span[@class='rct-checkbox']")).click();
            }
            else{
                js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[text()='"+category[1]+"']/parent::label/span[@class='rct-checkbox']")));
                driver.findElement(By.xpath("//span[text()='"+category[1]+"']/parent::label/span[@class='rct-checkbox']")).click();
            }
        }
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[@class='text-success']")));
        //resume the execution for 2 secs
        Thread.sleep(2000);

        String selectedOption=driver.findElement(By.xpath("//span[@class='text-success']")).getText();
        if(selectedOption.equalsIgnoreCase(category[2])){
            System.out.println("Expected option "+category[2]+" is selected");
        }
        else
            throw new Exception("Expected option"+category[2]+" is not selected");

        driver.close();
        driver.quit();
    }
}
