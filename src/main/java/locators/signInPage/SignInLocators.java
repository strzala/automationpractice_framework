package locators.signInPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignInLocators {

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "passwd")
    public WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    public WebElement signInButton;

    @FindBy(css = ".lost_password > a")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/ol/li")
    public WebElement errorMessage;

}
