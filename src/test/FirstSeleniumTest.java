package test;

import config.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumTest {

    public static String browser;
    static WebDriver driver;
    public static void main(String[] args) {
//        setBrowser();
        PropertiesFile.readPropertiesFile();
        setBrowserConfig();
        runTest();
        PropertiesFile.writePropertiesFile();
    }

    //Set three functions
    //setBrowser
    //setBrowserConfig
    //runTest

    public static void setBrowser() {
        browser = "Chrome";
    }
    public static void setBrowserConfig() {
        String projectLocation = System.getProperty("user.dir");

        if (browser.contains("Firefox")) {
            System.setProperty("webdriver.gecko.driver", projectLocation+"\\lib\\drivers\\geckodriver.exe");
            System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            driver = new FirefoxDriver();
        }

        if (browser.contains("Chrome")) {
            System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }

    }
    public static void runTest() {
        driver.get("https://udemy.com/");
        driver.quit();
    }

}
