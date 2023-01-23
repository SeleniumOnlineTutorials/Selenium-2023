import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class FillingTextFields {
    public static void main(String[] args) throws Exception {
        String name="Vyshnavi";
        String email="Selenium.onlinetutorials@gmail.com";
        String currentAddress="plot No 234-3-23, Hyderabad - 5000083";
        String permenantAddress="plot No 234-3-23, Hyderabad - 5000083";
        System.setProperty("webdriver.chrome.driver","D:\\Selenium Jars\\chrome 108\\chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        // Maximize the window
        driver.manage().window().maximize();
        //launch the application
        driver.get("https://demoqa.com/text-box");
        //resume the execution for 5 secs
        Thread.sleep(5000);
        driver.findElement(By.id("userName")).sendKeys(name);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
        driver.findElement(By.id("permanentAddress")).sendKeys(permenantAddress);
        Thread.sleep(5000);

        //scroll to element
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("submit")));

        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("name")));
        //Validation
        String nameOutput[]=driver.findElement(By.id("name")).getText().split(":");
        String emailOutput[] = driver.findElement(By.id("email")).getText().split(":");
        String cAddress[]= driver.findElement(By.xpath("//p[@id='currentAddress']")).getText().split(":");
        String pAddress[]=driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText().split(":");

        System.out.println(nameOutput[1]+" "+emailOutput[1]+" "+cAddress[1]+" "+pAddress[1]);

        if(name.equalsIgnoreCase(nameOutput[1].trim())){
            System.out.println("Name is stored properly");
        }
        else
            throw new Exception("Name is not stored properly");
        if(email.equalsIgnoreCase(emailOutput[1].trim())){
            System.out.println("email is stored properly");
        }
        else
            throw new Exception("email is not stored properly");
        if(currentAddress.equalsIgnoreCase(cAddress[1].trim())){
            System.out.println("currentAddress is stored properly");
        }
        else
            throw new Exception("currentAddress is not stored properly");
        if(permenantAddress.equalsIgnoreCase(pAddress[1].trim())){
            System.out.println("permenantAddress is stored properly");
        }
        else
            throw new Exception("permenantAddress is not stored properly");

        //closing the driver and quiting he execution
        driver.close();
        driver.quit();

    }
}
