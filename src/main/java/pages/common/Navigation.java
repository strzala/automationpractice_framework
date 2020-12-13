package pages.common;

import locators.common.NavigationLocators;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import util.webdriverProvider.SeleniumExecutor;

import static util.helpers.ElementHelpers.CustomClickHelper.click;

public class Navigation extends BasePage {

    NavigationLocators locators;

    public Navigation(){
        locators = new NavigationLocators();
        PageFactory.initElements(SeleniumExecutor.getDriver(), locators);
    }

    public void clickSignInLink(){
        click(locators.signInLink);
    }

    public void clickContactUs(){
        click(locators.contactUs);
    }
}
