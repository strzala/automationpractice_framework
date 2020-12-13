package locators.checkoutPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutLocators {

    @FindBy(css = "[href*='order&step=1']")
    public WebElement proceedToStep2;

    @FindBy(css = "[name='processAddress']")
    public WebElement proceedToStep4;

    @FindBy(css = "[name='processCarrier']")
    public WebElement proceedToStep5;

    @FindBy(className = "checker")
    public WebElement termsOfServiceCheckobx;

    @FindBy(className = "bankwire")
    public WebElement payBankWire;

    @FindBy(className = "cheque")
    public WebElement payCheck;

    @FindBy(css = "#cart_navigation > button")
    public WebElement completeOrder;

    @FindBy(css = "#center_column > div")
    public WebElement successBankWireMessage;

    @FindBy(className = "alert-success")
    public WebElement successChequeMessage;


}
