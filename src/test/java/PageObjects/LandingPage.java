package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        this.driver=driver;
    }


    By search= By.xpath("//input[@type='search']");
    By productName=By.cssSelector("h4.product-name");
    By topDeals=By.xpath("//a[text()='Top Deals']");
    By plusIcon=By.cssSelector("a.increment");
    By addToCart=By.xpath("//button[text()='ADD TO CART']");

    public void searchProduct(String name)
    {
        driver.findElement(search).sendKeys(name);
    }

    public String getProductNameText()
    {
        return driver.findElement(productName).getText();
    }

    public void navigateToTopDeals()
    {
        driver.findElement(topDeals).click();
    }

    public void addItems(int n)
    {
        for(int i=1;i<=n;i++)
        {
            driver.findElement(plusIcon).click();
        }
    }

    public void addTocart()
    {
        driver.findElement(addToCart).click();
    }
}
