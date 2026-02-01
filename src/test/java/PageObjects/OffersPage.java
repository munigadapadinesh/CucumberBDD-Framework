package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    WebDriver driver;

    public OffersPage(WebDriver driver)
    {
        this.driver=driver;
    }


    By search= By.xpath("//input[@type='search']");
    By productName=By.xpath("//td[1]");

    public void searchProduct(String name)
    {
        driver.findElement(search).sendKeys(name);
    }

    public String getProductNameText() throws InterruptedException {
        Thread.sleep(5000);
        return driver.findElement(productName).getText();
    }
}
