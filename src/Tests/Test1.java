package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends BaseDriver{

    /*

        Enter username and password
        Click on login button
        Click on contacts dropdown (on left top)
        Click on contacts button
        Click on create contact button
        Enter email
        Enter First name
        Enter Last name
        Click on Create Contact button
        Verify email and first name as entered
        Click on actions dropdown
        Click on delete button
        Click on Delete contact button


     */

    @Test
    public void test1(){

        driver.findElement(By.id("nav-secondary-contacts")).click();

        driver.findElement(By.xpath("//span[text()='Create contact']")).click();

        String email="halitt@gmail.com";
        driver.findElement(By.xpath("//input[@data-selenium-test='property-input-email']")).sendKeys(email);

        String fname="steven";
        driver.findElement(By.xpath("//input[@data-selenium-test='property-input-firstname']")).sendKeys(fname);

        String lname="gerrard";
        driver.findElement(By.xpath("//input[@data-selenium-test='property-input-lastname']")).sendKeys(lname);

        driver.findElement(By.xpath("//button[@data-selenium-test='base-dialog-confirm-btn']")).click();

        String fNameVal =  driver.findElement(By.xpath("//input[@data-selenium-test='property-input-firstname']")).getAttribute("value");

        String emailVal =   driver.findElement(By.xpath("//div[@data-selenium-test='property-input-email']")).getText();

        Assert.assertEquals(fNameVal ,fname );
        Assert.assertEquals(emailVal ,email );

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
