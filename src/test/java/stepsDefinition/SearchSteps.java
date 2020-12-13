package stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.common.HomePage;

public class SearchSteps {

    HomePage homePage;

    public SearchSteps() {
        this.homePage = new HomePage();
    }

    @Given("I am on Home page")
    public void iAmOnHomePage() {
        homePage.open();
    }

    @When("I type initial {string} of product name")
    public void iTypeInitialOfProductName(String text) {
        homePage.enterSearchInput(text);
    }

    @Then("{string} with corresponding product names are shown in the search lookup")
    public void withCorrespondingProductNamesAreShownInTheSearchLookup(String search){
        Assert.assertTrue(homePage.verifySearchResults(search), "Contains different results");
    }
}
