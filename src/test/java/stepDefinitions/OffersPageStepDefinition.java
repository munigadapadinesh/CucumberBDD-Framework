package stepDefinitions;

import PageObjects.LandingPage;
import PageObjects.OffersPage;
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

import java.util.Set;

public class OffersPageStepDefinition {
    public String OfferPageproductName;
    TestContextSetup testContextSetup;

    public OffersPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }

    @Then("^user searched for (.+) shortname in offers page$")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String prodname) {
        switchToOffersPage();
        OffersPage offersPage=testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchProduct(prodname);

    }

    @And("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() throws InterruptedException {
        OffersPage offersPage=testContextSetup.pageObjectManager.getOffersPage();
        OfferPageproductName=offersPage.getProductNameText();
        Assert.assertEquals(OfferPageproductName,testContextSetup.LandingPageproductName);
    }

    public void switchToOffersPage()
    {
        LandingPage landingPage=testContextSetup.pageObjectManager.getLandingPage();
        landingPage.navigateToTopDeals();
        testContextSetup.genericUtils.switchToChild();
    }
}
