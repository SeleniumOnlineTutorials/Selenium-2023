import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium Jars\\chrome 108\\chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='selenium']")).click();
        Thread.sleep(15000);
        driver.findElement(By.xpath("//a[@href='https://www.selenium.dev/']")).click();

    }

}
