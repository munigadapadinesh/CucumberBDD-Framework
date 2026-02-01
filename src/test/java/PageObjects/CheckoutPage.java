package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver)
    {
        this.driver=driver;
    }


    By cartBag= By.xpath("//img[@alt='Cart']");
    By proceedToCheckout=By.xpath("//button[text()='PROCEED TO CHECKOUT']");
    By promoBtn=By.cssSelector(".promoBtn");
    By placeOrder=By.xpath("//button[text()='Place Order']");
    By productName=By.cssSelector("p.product-name");

    public void checkoutItems() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(cartBag).click();
        driver.findElement(proceedToCheckout).click();
        Thread.sleep(5000);
    }

    public Boolean verifyPromoBtn()
    {
        return driver.findElement(promoBtn).isDisplayed();
    }

    public Boolean verifyplaceOrder()
    {
        return driver.findElement(placeOrder).isDisplayed();
    }

    public String getProductName()
    {
        return driver.findElement(productName).getText();
    }


}

