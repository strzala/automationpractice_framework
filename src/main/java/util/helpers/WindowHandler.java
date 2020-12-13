package util.helpers;


import org.openqa.selenium.WebDriver;
import util.webdriverProvider.SeleniumExecutor;

public class WindowHandler {

    public static WebDriver switchToWindow(String windowHandle) {
        WebDriver tmp = SeleniumExecutor.getDriver().switchTo().window(windowHandle);
        try {
            Thread.sleep(SeleniumExecutor.TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return tmp;
    }


}
