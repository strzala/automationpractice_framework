package util.helpers.ElementHelpers;

import com.google.common.base.Function;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.webdriverProvider.SeleniumExecutor;

import java.util.List;


@Log4j
public class CustomWaitHelper {

    public static boolean waitForJsJq() {
        WebDriver webDriver = SeleniumExecutor.getDriver();
        WebDriverWait wait = SeleniumExecutor.getWaitDriver();

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) webDriver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    public static void waitForElementDisplayed(WebElement e) {
        WebDriverWait waitDriver = SeleniumExecutor.getWaitDriver();
        try {
            waitDriver.until((Function<? super WebDriver, Boolean>) d -> e.isDisplayed());
        } catch (WebDriverException wde) {
            wde.printStackTrace();
        }
    }

    public static void waitForElementsDisplayed(List<WebElement> webElements) {
        WebDriverWait wait = SeleniumExecutor.getWaitDriver();
        wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
    }


}
