package stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.common.HomePage;
import pages.common.Navigation;
import pages.myAccount.MyAccountPage;
import pages.signinPage.SignInPage;

public class SignInSteps {

    HomePage homePage;
    SignInPage signInPage;
    MyAccountPage myAccountPage;
    Navigation navigation;

    public SignInSteps(){
        this.navigation = new Navigation();
        this.homePage = new HomePage();
        this.signInPage = new SignInPage();
        this.myAccountPage = new MyAccountPage();
    }

    @Given("I am on Sign In page")
    public void iAmOnSignInPage() {
        homePage.open();
        navigation.clickSignInLink();
    }

    @When("I enter valid {string} and {string}")
    public void iEnterValidAnd(String email, String password) {
        signInPage.signInWithCredentials(email, password);
    }

    @And("I click on Sign in button")
    public void iClickOnSignInButton() {
        signInPage.clickSignInButton();
    }

    @Then("I am logged to My Account")
    public void iAmLoggedToMyAccount() {
        Assert.assertEquals(myAccountPage.isMyAccountDisplayed(), true,"My Account label is displayed");
    }

    @When("I enter invalid {string} or {string}")
    public void iEnterInvalidOr(String email, String password) {
        signInPage.signInWithCredentials(email, password);
    }

    @Then("Error {string} is displayed")
    public void errorIsDisplayed(String message) {
        Assert.assertEquals(signInPage.getErrorMessage(), message, "Error message is displayed");
    }
}

