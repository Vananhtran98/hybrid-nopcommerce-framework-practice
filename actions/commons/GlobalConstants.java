package commons;

public class GlobalConstants {
    // System Infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String SEPARATOR = System.getProperty("file.separator");

    // App Infor User
    public static final String DEV_USER_URL = "http://demo.nopcommerce/";
    public static final String STAGING_USER_URL = "http://staging.nopcommerce/";
    public static final String LIVE_USER_URL = "http://live.nopcommerce/";

    // App Infor Admin
    public static final String DEV_ADMIN_URL = "http://demo.nopcommerce/admin";
    public static final String STAGING_ADMIN_URL = "http://staging.nopcommerce/admin";
    public static final String LIVE_ADMIN_URL = "http://live.nopcommerce/admin";

    public static final String ADMIN_USERNAME = "anh@automationfc.vn";
    public static final String ADMIN_PASSWORD = "anh@automationfc.vn";

    // Wait Infor
    public static final long SHORT_TIMEOUT = 10;
    public static final long LONG_TIMEOUT = 30;

    // Download/ Upload file
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;

    // Retry Case Failed
    public static final int RETRY_NUMBER = 3;

    // Browser Logs/ Extension
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR + "browserLogs" + SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + SEPARATOR + "browserExtensions" + SEPARATOR;

    // HTML Report Folder
    public static final String REPORTNG_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" + SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" + SEPARATOR;

    // Data Test/ Environment
    public static final String DATA_TEST_PATH = PROJECT_PATH + SEPARATOR + "dataTest" + SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + SEPARATOR + "environmentConfig" + SEPARATOR;

    public static final String JIRA_SITE_URL = "https://automation-vn.atlassian.net/";
    public static final String JIRA_USERNAME = "tranthivananh1711998@gmail.com";
    public static final String JIRA_API_KEY = "ATATT3xFfGF0Y3rnj2NgHs8CwqzEr9j383l0vosyuPnwmBWtcp5Op1eCd7F85Ha572xDsjO2jaeZA_OGu6DIc9Jw_goI79NM15jtI9xT2Cv6tEoEjQGApgn2woI2fCk5-Syl1pOGMjRCj2p19eIg62-hvLKSrKs7mnHcBC_BoYO50XTbYVSb9bg=5C384CC3";
    public static final String JIRA_PROJECT_KEY = "SCRUM";
}
