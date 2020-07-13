package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 extends BaseDriver{


    /*

        Enter username and password
        Click on login button
        Click on contacts dropdown (on left top)
        Click on companies button
        Click on create companies button
        Enter the company domain
        Enter the name
        Click on Create company button
        Verify company domain as entered
         Click on actions dropdown
        Click on delete button
        Click on Delete contact button

     */

    @Test
    public void test1(){

        driver.findElement(By.id("nav-secondary-companies")).click();

        driver.findElement(By.xpath("//span[text()='Create company']")).click();

        String domain="kerler123.com";
        driver.findElement(By.xpath("//input[@data-selenium-test='property-input-domain']")).sendKeys(domain);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String nameCreate="kk123";
        WebElement nameElemenet  = driver.findElement(By.xpath("//input[@data-selenium-test='property-input-name']"));
        nameElemenet.clear();
        nameElemenet.sendKeys(nameCreate);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//button[@data-selenium-test='base-dialog-confirm-btn']")).click();

        String domainText =   driver.findElement(By.xpath("//div[@data-test-id='domain-input']")).getText();

        String name =  driver.findElement(By.xpath("//textarea[@data-selenium-test='property-input-name']")).getText();

        Assert.assertEquals(domainText ,domain );
        Assert.assertEquals(name ,nameCreate );

        driver.findElement(By.xpath("//span[text()='Actions']")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//button[@data-selenium-test='profile-settings-profileSettings.delete']")).click();

        driver.findElement(By.xpath("//button[@data-selenium-test='delete-dialog-confirm-button']")).click();


    }
}
