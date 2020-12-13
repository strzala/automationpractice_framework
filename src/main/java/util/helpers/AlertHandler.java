package util.helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.helpers.ElementHelpers.CustomWaitHelper;
import util.webdriverProvider.SeleniumExecutor;


public class AlertHandler {

    public static void accept() {
        alertHandle(true);
    }

    public static void dismiss() {
        alertHandle(false);
    }

    private static void alertHandle(Boolean accept) {
        Alert alert = SeleniumExecutor.getWaitDriver().until(ExpectedConditions.alertIsPresent());

        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }

        try {
            CustomWaitHelper.waitForJsJq();
        } catch (UnhandledAlertException e) {
            e.printStackTrace();
        }
    }
}
