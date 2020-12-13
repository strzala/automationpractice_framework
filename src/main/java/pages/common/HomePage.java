package pages.common;

import locators.common.HomeLocators;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import util.enums.PagesType;
import util.webdriverProvider.SeleniumExecutor;
import java.util.*;
import static util.helpers.ElementHelpers.CustomClickHelper.click;
import static util.helpers.ElementHelpers.CustomWaitHelper.waitForElementsDisplayed;


public class HomePage extends BasePage {

    private HomeLocators locators;

    public HomePage(){
        locators = new HomeLocators();
        PageFactory.initElements(SeleniumExecutor.getDriver(), locators);
    }
    public void open(){
        openPage(PagesType.HOME);
    }

    public void enterSearchInput(String text){
        locators.searchInputField.sendKeys(text);
    }

    public boolean verifySearchResults(String search) {
        List<String> allProductNames = new ArrayList<>();
        waitForElementsDisplayed(locators.searchResults);
        locators.searchResults.stream().forEach(element -> allProductNames.add(element.getText()));
        if (allProductNames.stream().allMatch(s -> s.contains(search)))
            return true;
        else
            return false;
    }
    public void clickWomenCategoryLink(){
        click(locators.womenCategoryLink);
    }

}

