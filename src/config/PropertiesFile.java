package config;

import test.FirstSeleniumTest;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    static Properties prop = new Properties();

    public static void main(String[] args) {
        readPropertiesFile();
        writePropertiesFile();
    }

    public static void readPropertiesFile() {

        try {
            InputStream input = new FileInputStream("C:\\Users\\maria\\OneDrive\\Desktop\\Selenium\\SeleniumTest_\\src\\config\\config.properties");
            prop.load(input);
//            System.out.println(prop.getProperty("browser"));
            FirstSeleniumTest.browser = prop.getProperty("browser");
            System.out.println(FirstSeleniumTest.browser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writePropertiesFile() {
        try {
            OutputStream output = new FileOutputStream("C:\\Users\\maria\\OneDrive\\Desktop\\Selenium\\SeleniumTest_\\src\\config\\config.properties");
//            prop.setProperty("browser", "Chrome");
            prop.setProperty("result", "pass");
            prop.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
