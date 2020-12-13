package pages.checkout;

import locators.checkoutPage.CheckoutLocators;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import util.enums.PagesType;
import util.webdriverProvider.SeleniumExecutor;
import static util.helpers.ElementHelpers.CustomClickHelper.click;

public class CheckoutPage extends BasePage {

    private CheckoutLocators locators;

    public CheckoutPage() {
        locators = new CheckoutLocators();
        PageFactory.initElements(SeleniumExecutor.getDriver(), locators);
    }

    public void open(){
        openPage(PagesType.CHECKOUT);
    }

    public boolean performPayment(String payment) {
        click(locators.proceedToStep2);
        click(locators.proceedToStep4);
        click(locators.termsOfServiceCheckobx);
        click(locators.proceedToStep5);

        switch (payment) {
            case "bankwire":
                click(locators.payBankWire);
                click(locators.completeOrder);
                return locators.successBankWireMessage.getText().contains("is complete");
            case "cheque":
                click(locators.payCheck);
                click(locators.completeOrder);
                return locators.successChequeMessage.getText().contains("is complete");

            default: throw new IllegalArgumentException();
        }
    }
}
