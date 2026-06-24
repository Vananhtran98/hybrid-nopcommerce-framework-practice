package pageObjects.saucelabs;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saucelabs.InventoryPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPageObject extends BasePage {
    private WebDriver driver;

    public InventoryPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSortDropDown(String sortItem) {
        waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
        selectItemInDropdown(driver, InventoryPageUI.SORT_DROPDOWN, sortItem);
        sleepInSecond(2);
    }

    // Java 7 trở xuống
    public boolean isNameSortAscending() {
        List<WebElement> productNameElement = getListElement(driver, InventoryPageUI.PRODUCT_NAME);
        List<String> productNameText = new ArrayList<String>();

        for (WebElement productName: productNameElement) {
            productNameText.add(productName.getText());
        }

        List<String> productNameTextClone = new ArrayList<>(productNameText);
        Collections.sort(productNameTextClone);
        return productNameTextClone.equals(productNameText);
    }

    public boolean isNameSortDescending() {
        List<WebElement> productNameElement = getListElement(driver, InventoryPageUI.PRODUCT_NAME);
        List<String> productNameText = new ArrayList<String>();

        for (WebElement productName: productNameElement) {
            productNameText.add(productName.getText());
        }

        List<String> productNameTextClone = new ArrayList<>(productNameText);
        Collections.sort(productNameTextClone);
        // productNameTextClone (ASC)

        Collections.reverse(productNameTextClone);
        // productNameTextClone (DESC)
        return productNameTextClone.equals(productNameText);
    }

    public boolean isPriceSortAscending() {
        List<WebElement> productPriceElement = getListElement(driver, InventoryPageUI.PRODUCT_PRICE);
        List<Float> productPriceText = new ArrayList<Float>();

        for (WebElement productName: productPriceElement) {
            productPriceText.add(Float.valueOf(productName.getText().replace("$", "")));
        }

        List<Float> productPriceTextClone = new ArrayList<Float>(productPriceText);
        Collections.sort(productPriceTextClone);

        return productPriceTextClone.equals(productPriceText);
    }

    public boolean isPriceSortDescending() {
        List<WebElement> productPriceElement = getListElement(driver, InventoryPageUI.PRODUCT_PRICE);
        List<Float> productPriceText = new ArrayList<Float>();

        for (WebElement productName: productPriceElement) {
            productPriceText.add(Float.valueOf(productName.getText().replace("$", "")));
        }

        List<Float> productPriceTextClone = new ArrayList<Float>(productPriceText);
        Collections.sort(productPriceTextClone);
        Collections.reverse(productPriceTextClone);

        return productPriceTextClone.equals(productPriceText);
    }
}
