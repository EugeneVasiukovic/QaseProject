package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ProjectListPage;
import pages.ProjectPage;
import steps.ProjectListSteps;
import steps.ProjectSteps;
import steps.loginSteps;

import java.util.HashMap;
import java.util.Map;


import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    protected loginSteps loginSteps;
    protected ProjectListSteps projectListSteps;
    protected ProjectListPage projectListPage;
    protected ProjectSteps projectSteps;
    protected ProjectPage projectPage;
    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");


    public void initPages(){
        loginSteps = new loginSteps();
        projectListSteps = new ProjectListSteps();
        projectListPage = new ProjectListPage();
        projectSteps = new ProjectSteps();
        projectPage = new ProjectPage();
    }

    @BeforeMethod
    public  void initTest(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize =  "1024x768";
        initPages();
    }

    @AfterMethod
    public void endTest(){
        getWebDriver().quit();
    }
}

