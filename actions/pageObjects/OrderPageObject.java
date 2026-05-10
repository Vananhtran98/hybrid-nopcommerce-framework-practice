package pageObjects;

import org.openqa.selenium.WebDriver;


public class OrderPageObject extends SidebarPageObject {
    private WebDriver driver;

    public OrderPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}

