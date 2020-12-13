package locators.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomeLocators {

    @FindBy(id = "search_query_top")
    public WebElement searchInputField;

    @FindBy(xpath = "//*[@id='index']/div[2]/ul/li")
    public List <WebElement> searchResults;

    @FindBy(linkText = "Women")
    public WebElement womenCategoryLink;


}
