package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory extends BasePage {

    private WebDriver driver;

    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "gender-male")
    private WebElement genderMaleRadio;

    @CacheLookup
    @FindBy(id = "FirstName")
    private WebElement firstNameTextbox;

    @FindBy(id = "LastName")
    @CacheLookup
    private WebElement lastNameTextbox;

    @FindBy(id = "Email")
    @CacheLookup
    private WebElement emailTextbox;

    @FindBy(id = "Company")
    @CacheLookup
    private WebElement companyTextbox;

    @FindBy(id = "Password")
    @CacheLookup
    private WebElement passwordTextbox;

    @FindBy(id = "ConfirmPassword")
    @CacheLookup
    private WebElement confirmPasswordTextbox;

    @FindBy(id = "register-button")
    @CacheLookup
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    @CacheLookup
    private WebElement registerSuccessMessage;

    @FindBy(className = "ico-logout")
    @CacheLookup
    private WebElement logoutLink;

    @FindBy(className = "ico-login")
    @CacheLookup
    private WebElement loginLink;

    @FindBy(xpath = "//li[text()='1']")
    @CacheLookup
    private WebElement oneNumberText;

    public void clickToOneNumberText() {
        waitForElementClickable(driver, oneNumberText);
        clickToElement(oneNumberText);
    }

    public boolean isOneNumberTextSelected() {
        waitForElementSelected(driver, oneNumberText);
        return isElementSelected(oneNumberText);
    }

    public void clickToMaleRadio() {
        waitForElementClickable(driver, genderMaleRadio);
        clickToElement(genderMaleRadio);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, firstNameTextbox);
        sendKeyToElement(firstNameTextbox, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, lastNameTextbox);
        sendKeyToElement(lastNameTextbox, lastName);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, emailTextbox);
        sendKeyToElement(emailTextbox, emailAddress);
    }

    public void enterToCompanyTextbox(String companyName) {
        waitForElementVisible(driver, companyTextbox);
        sendKeyToElement(companyTextbox, companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendKeyToElement(passwordTextbox, password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, confirmPasswordTextbox);
        sendKeyToElement(confirmPasswordTextbox, password);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(registerButton);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, registerSuccessMessage);
        return getElementText(registerSuccessMessage);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver, logoutLink);
        clickToElement(logoutLink);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, loginLink);
        clickToElement(loginLink);

    }
}
