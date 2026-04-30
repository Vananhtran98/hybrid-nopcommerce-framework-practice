package com.nopcommerce.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_01_Repeat_Yourself {

    private WebDriver driver;

    private String firstName, lastName, emailAddress, companyName, password;
    private String getEmailErrorMessage;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.get("http://demo.nopcommerce/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        emailAddress = "thomasmuller" + generateRandomNumber() + "@gmail.de";

    }

    @Test
    public void TC_01_Register() {
        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.cssSelector("input#gender-male")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Thomas");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Muller");
        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Company")).sendKeys("Bayern Munich");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123456789");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456789");
        driver.findElement(By.cssSelector("button#register-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");

        driver.findElement(By.cssSelector("a.ico-logout")).click();
    }

    @Test
    public void TC_02_Login() {

        driver.findElement(By.cssSelector("a.ico-login")).click();

        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123456789");

        driver.findElement(By.cssSelector("button.login-button")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account' and text() = 'My account']")).isDisplayed());

    }

    @Test
    public void TC_03_MyAccount() {

        driver.findElement(By.cssSelector("a.ico-account")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input#gender-male")).isSelected());

        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), "Thomas");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), "Muller");

        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), "Bayern Munich");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();

    }

    private int generateRandomNumber() {
        return new Random().nextInt(99999);
    }
}
