package pageUIs.orangehrm.pim.employee;

public class PersonalDetailsPUI {
    public static final String EMPLOYEE_IMAGE = "Css=div.orangehrm-edit-employee-image>img.employee-image";
    public static final String SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER = "XPath=//h6[text()='Change Profile Picture']/following-sibling::form//button[contains(string(),'Save')]";
    public static final String FIRST_NAME_TEXTBOX = "name=firstName";
    public static final String LAST_NAME_TEXTBOX = "name=lastName";
    public static final String EMPLOYEE_ID_TEXTBOX = "XPath=//label[text()='Employee Id']/parent::div/following-sibling::div//input";
    public static final String DRIVER_LICENSE_TEXTBOX = "XPath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div//input";

    public static final String LICENSE_EXPIRY_DATE_TEXTBOX = "XPath=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";
    public static final String NATIONALITY_DROPDOWN_PARENT = "XPath=//label[text()='Nationality']/parent::div/following-sibling::div//i";
    public static final String NATIONALITY_DROPDOWN_CHILD = "XPath=//label[text()='Nationality']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
    public static final String NATIONALITY_DROPDOWN_SELECTED = "XPath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String MARITAL_STATUS_DROPDOWN_PARENT = "XPath=//label[text()='Marital Status']/parent::div/following-sibling::div//i";
    public static final String MARITAL_STATUS_DROPDOWN_CHILD = "XPath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
    public static final String MARITAL_STATUS_DROPDOWN_SELECTED = "XPath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String DATE_OF_BIRTH_TEXTBOX = "XPath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
    public static final String GENDER_RADIO_BUTTON = "XPath=//label[text()='Gender']/parent::div/following-sibling::div//label[contains(string(),'%s')]/input";
    public static final String SAVE_BUTTON_AT_CHANGE_PERSONAL_DETAILS = "XPath=//h6[text()='Personal Details']/following-sibling::form//button[contains(string(),'Save')]";



}
