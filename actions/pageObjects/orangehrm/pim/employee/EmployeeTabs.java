package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangehrm.pim.employee.EmployeeTabsPUI;

public class EmployeeTabs extends BasePage {
    private WebDriver driver;

    public EmployeeTabs(WebDriver driver) {
        this.driver = driver;
    }

    public PersonalDetailsPO openPersonalDetailPage() {
        waitForElementClickable(driver, EmployeeTabsPUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver, EmployeeTabsPUI.PERSONAL_DETAIL_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    public ContactDetailsPO openContactDetailPage() {
        waitForElementClickable(driver, EmployeeTabsPUI.CONTACT_DETAIL_LINK);
        clickToElement(driver, EmployeeTabsPUI.CONTACT_DETAIL_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getContactDetailsPage(driver);
    }

    public EmergencyContactsPO openEmergencyContactPage() {
        waitForElementClickable(driver, EmployeeTabsPUI.EMERGENCY_DETAIL_LINK);
        clickToElement(driver, EmployeeTabsPUI.EMERGENCY_DETAIL_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmergencyContactPage(driver);
    }
}
