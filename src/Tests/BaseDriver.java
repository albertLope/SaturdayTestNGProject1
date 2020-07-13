package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseDriver {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters({"username" , "password"})
    public void beforeMethod(String username , String password){

        System.setProperty("webdriver.chrome.driver", "D:\\Selenium dependency\\drivers\\chromedriver.exe");
         driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://app.hubspot.com/login");

        WebElement Username = driver.findElement(By.id("username"));
        Username.sendKeys("technostudyy@gmail.com");

        WebElement passWordInput = driver.findElement(By.id("password"));
        passWordInput.sendKeys("TechnoStudy123");

        driver.findElement(By.id("loginBtn")).click();

        driver.findElement(By.id("nav-primary-contacts-branch")).click();
    }
}
