package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;
import pageUIs.CustomerInfoPageUI;
import pageUIs.OrderPageUI;

public class AddressPageObject extends SidebarPageObject {
    private WebDriver driver;

    public AddressPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
