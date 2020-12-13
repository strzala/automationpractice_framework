package stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.checkout.CheckoutPage;
import pages.common.HomePage;
import pages.common.Navigation;
import pages.productPage.ProductPage;
import pages.signinPage.SignInPage;

public class CheckoutSteps {

    HomePage homePage;
    SignInPage signInPage;
    CheckoutPage checkoutPage;
    ProductPage productPage;
    Navigation navigation;

    public CheckoutSteps(){
        this.navigation = new Navigation();
        this.homePage = new HomePage();
        this.signInPage = new SignInPage();
        this.checkoutPage = new CheckoutPage();
        this.productPage = new ProductPage();
    }

    @Given("I am a logged user")
    public void iAmALoggedUser() {
        homePage.open();
        navigation.clickSignInLink();
        signInPage.performSignInWithPropertiesDetails();
        homePage.open();
    }

    @When("I have a product in my Cart")
    public void iHaveAProductInMyCart() {
        productPage.open();
        productPage.addProductToCart();
    }

    @And("I go to the checkout")
    public void iGoToTheCheckout() {
        checkoutPage.open();
    }

    @Then("I am able to complete payment using {string} option")
    public void iAmAbleToCompletePaymentUsingOption(String payment) {
        Assert.assertTrue(checkoutPage.performPayment(payment));
    }

}
