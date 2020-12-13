package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import util.webdriverProvider.SeleniumExecutor;

public class AfterHooks {

    @After(order = 999)
    public void tearDown(Scenario s){
        if (s.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) SeleniumExecutor.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            s.attach(screenshot, "image/png", "ScreenshotOnFailure" );
        }
        SeleniumExecutor.stop();
    }
}
