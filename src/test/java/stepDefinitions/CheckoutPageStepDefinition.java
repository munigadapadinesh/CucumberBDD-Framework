package stepDefinitions;

import PageObjects.CheckoutPage;
import PageObjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

import java.io.IOException;

public class CheckoutPageStepDefinition {
    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
        checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_items(String name) throws InterruptedException {
        checkoutPage.checkoutItems();
        Assert.assertTrue(checkoutPage.getProductName().split("-")[0].contains(name));
    }


@Then("verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order()
{
    Assert.assertTrue(checkoutPage.verifyPromoBtn());
    Assert.assertTrue(checkoutPage.verifyplaceOrder());
}

}
