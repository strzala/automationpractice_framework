package pages.signinPage;

import locators.signInPage.SignInLocators;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import util.helpers.PropertiesHandler;
import util.webdriverProvider.SeleniumExecutor;

public class SignInPage extends BasePage {

    private SignInLocators locators;

    public SignInPage() {
        locators = new SignInLocators();
        PageFactory.initElements(SeleniumExecutor.driver, locators);
    }

    public void signInWithCredentials(String email, String password) {
        locators.emailField.clear();
        locators.emailField.sendKeys(email);
        locators.passwordField.clear();
        locators.passwordField.sendKeys(password);
    }

    public void clickSignInButton(){
        locators.signInButton.click();
    }

    public String getErrorMessage(){
        return locators.errorMessage.getText();
    }

    public void performSignInWithPropertiesDetails(){
        locators.emailField.sendKeys(PropertiesHandler.getProperty("account_email"));
        locators.passwordField.sendKeys(PropertiesHandler.getProperty("account_password"));
        clickSignInButton();
    }

}
