package locators.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationLocators {

    @FindBy(className = "login")
    public WebElement signInLink;

    @FindBy(id = "contact-link")
    public WebElement contactUs;

}
