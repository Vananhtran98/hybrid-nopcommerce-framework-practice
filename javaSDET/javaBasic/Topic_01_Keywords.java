package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_01_Keywords {
    // Nguyên thủy (Primitive Type)
    char c = 'a';
    byte bNumber = 10;
    short sNumber = 100;
    int iNumber = 1000;
    long lNumber = 10000;
    float fNumber = 15.7f;
    double dNumber = 45.88d;
    boolean bStatus = true;

    // Tham chiếu (Reference Type)
    String fullName = "Automation Test";

    // Hàm này ko cần trả về gì hết
    void clickToLoginButton() {

    }

    // Hàm này cần trả về kiểu string
    String getLoginMessage() {
        // Chỉ được return 1 lần
        return "";
    }

    // Bất kì 1 class nào cũng truy cập vào biến này được
    public String address = "145 Hoàng Cầu - Long Biên - Hà Nội";

    // Cho việc kế thừa
    protected String city = "TP. Hồ Chí Minh";

    // Chỉ class này dùng được
    private String phone = "085562563";

    // Trong cùng package
    String zipCode = "650000";

    // package: define xem class/ interface nằm trong package nào

    WebDriver driver;

    // Biểu thức điều kiện

    public WebDriver getBrowserDriver(String browserName) {
        if(browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new EdgeDriver();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            
        }

        switch (browserName) {
            case "firefox":
                driver = new FirefoxDriver();
            case "chrome":
                driver = new ChromeDriver();
            default:
                driver = new EdgeDriver();
        }
        return driver;
    }
}
