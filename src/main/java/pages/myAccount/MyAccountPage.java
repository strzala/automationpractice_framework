package pages.myAccount;

import locators.myAccountPage.MyAccountLocators;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import util.webdriverProvider.SeleniumExecutor;

public class MyAccountPage extends BasePage {

    private MyAccountLocators locators;

    public MyAccountPage() {
        locators = new MyAccountLocators();
        PageFactory.initElements(SeleniumExecutor.driver, locators);
    }

    public boolean isMyAccountDisplayed(){
        return locators.infoAccountLabel.isDisplayed();
    }

}
