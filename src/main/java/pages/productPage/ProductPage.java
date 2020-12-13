package pages.productPage;

import locators.productPage.ProductLocators;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import util.enums.PagesType;
import util.webdriverProvider.SeleniumExecutor;

public class ProductPage extends BasePage {

    private ProductLocators locators;

    public ProductPage() {
        locators = new ProductLocators();
        PageFactory.initElements(SeleniumExecutor.driver, locators);
    }
    public void open(){
        openPage(PagesType.PRODUCT);
    }

    public void addProductToCart() {
        locators.addToCartButton.click();
    }
}
