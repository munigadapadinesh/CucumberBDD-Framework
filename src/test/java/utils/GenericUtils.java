package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class GenericUtils {

    public WebDriver driver;

    public GenericUtils(WebDriver driver)
    {
        this.driver=driver;
    }


    public void switchToChild()
    {
        String parent=driver.getWindowHandle();
        Set<String> child=driver.getWindowHandles();
        for(String c:child)
        {
            if(!parent.equals(c))
            {
                driver.switchTo().window(c);
            }
        }
    }
}
