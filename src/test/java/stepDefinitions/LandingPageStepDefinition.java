package stepDefinitions;

import PageObjects.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utils.TestContextSetup;

import java.io.IOException;

public class LandingPageStepDefinition {
    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
        landingPage=testContextSetup.pageObjectManager.getLandingPage();

    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() throws IOException {
        testContextSetup.testBase.webDriverManager().manage().window().maximize();


    }


    @When("^user searched with Shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
        LandingPage landingPage=testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchProduct(shortname);
        Thread.sleep(5000);
        testContextSetup.LandingPageproductName=landingPage.getProductNameText().split("-")[0].trim();
System.out.println("Product Name: "+testContextSetup.LandingPageproductName);
    }

    @And("Add {int} items of the selected product to cart")
    public void addItems(int num)
    {
         landingPage.addItems(num);
         landingPage.addTocart();
    }



}
