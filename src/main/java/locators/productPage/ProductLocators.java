package locators.productPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductLocators {

    @FindBy(css = "#add_to_cart > button > span")
    public WebElement addToCartButton;


}
