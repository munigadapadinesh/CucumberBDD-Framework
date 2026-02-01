package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver webDriverManager() throws IOException {
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src/test/resources/global.properties");
        Properties prop=new Properties();
        prop.load(fis);
        String url=prop.getProperty("QAURL");
        String browser_properties=prop.getProperty("browser");
        String browser_maven=System.getProperty("browser");
        String browser=browser_maven!=null?browser_maven:browser_properties;
        if(browser.equalsIgnoreCase("chrome"))
        {
            if(driver==null)
            {
                driver=new ChromeDriver();
            }
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            if(driver==null)
            {
                driver=new FirefoxDriver();
            }
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            if(driver==null)
            {
                driver=new EdgeDriver();
            }
        }
        driver.get(url);
        return driver;
    }
}
