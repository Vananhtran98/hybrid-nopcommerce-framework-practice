package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_III_Inheritance extends BasePage{

    private WebDriver driver;

    String emailAddress;


    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();

        driver.get("http://demo.nopcommerce/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        emailAddress = "thomasmuller" + generateRandomNumber() + "@gmail.de";

    }

    @Test
    public void TC_01_Register() {
        waitForElementClickable(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");

        waitForElementClickable(driver, "//input[@id='gender-male']");
        clickToElement(driver, "//input[@id='gender-male']");

        sendKeyToElement(driver, "//input[@id = 'FirstName']", "Thomas");
        sendKeyToElement(driver, "//input[@id = 'LastName']", "Muller");

        sendKeyToElement(driver, "//input[@id = 'Email']", emailAddress);
        sendKeyToElement(driver, "//input[@id = 'Company']", "Bayern Munich");
        sendKeyToElement(driver, "//input[@id = 'Password']", "123456789");
        sendKeyToElement(driver, "//input[@id = 'ConfirmPassword']", "123456789");

        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

        waitForElementClickable(driver, "//a[@class='ico-logout']");
        clickToElement(driver, "//a[@class='ico-logout']");
    }

    @Test
    public void TC_02_Login() {

        waitForElementClickable(driver, "//a[@class='ico-login']");
        clickToElement(driver, "//a[@class='ico-login']");

        sendKeyToElement(driver, "//input[@id = 'Email']", emailAddress);
        sendKeyToElement(driver, "//input[@id = 'Password']", "123456789");

        waitForElementClickable(driver, "//button[contains(@class,'login-button')]");
        clickToElement(driver, "//button[contains(@class,'login-button')]");

        Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account' and text() = 'My account']"));

    }

    @Test
    public void TC_03_MyAccount() {

        waitForElementClickable(driver, "//a[@class='ico-account']");
        clickToElement(driver, "//a[@class='ico-account']");

        Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));

        Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), "Thomas");
        Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), "Muller");

        Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), "Bayern Munich");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();

    }

    private int generateRandomNumber() {
        return new Random().nextInt(99999);
    }
}
