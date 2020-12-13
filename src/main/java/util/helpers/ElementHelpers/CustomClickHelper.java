package util.helpers.ElementHelpers;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.webdriverProvider.SeleniumExecutor;

@Log4j
public class CustomClickHelper {

    public static void click(WebElement element) {
        element.click();
        try {
            CustomWaitHelper.waitForJsJq();
        } catch (UnhandledAlertException e) {
            e.printStackTrace();
        }
    }

    public static void performClick(WebElement we) {
        Actions action = new Actions(SeleniumExecutor.getDriver());
        action.moveToElement(we).click().perform();
    }
}
