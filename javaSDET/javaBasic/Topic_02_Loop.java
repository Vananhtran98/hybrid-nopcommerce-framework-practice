package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class Topic_02_Loop { // final: ko cho class khác kế thừa
    // final: ko cho phép gán lại giá trị mới
    public static String PI = "3.141875834";

    public final void clickToElement() {// ko cho class khác override lại

    }

    // throw
    // throws

    public static void clickToButton() throws InterruptedException {
        Thread.sleep(5000);

    }

    public static void main(String[] args) throws InterruptedException {
        Topic_02_Loop topic02 = new Topic_02_Loop();
        topic02.clickToElement();

        Topic_02_Loop.clickToButton();
        System.out.println(Topic_02_Loop.PI);

        Topic_02_Loop.PI = "3.1415632";

        System.out.println("For:");
        for (int i = 1; i <= 10; i++) {// Kiểm tra trước
            if (i == 5) {
                continue;
            }
        }

        System.out.println("While:");
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        System.out.println("Do-While:");
        i = 1;
        do { // Thực thi trước
            System.out.println(i);
            i++;
        } while (i <= 0); // Kiểm tra sau
    }
    public boolean isElementDisplayed() {
        WebDriver driver = new FirefoxDriver();
        WebElement element = driver.findElement(By.cssSelector(""));
        boolean status = false;
        try {
            status = element.isDisplayed();
        } catch(NoSuchElementException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception.getMessage());
        } finally { // Step bắt buộc phải chạy
            // Đóng kết nối vào DB/ Clean dữ liệu

        }
        return status;
    }
}
