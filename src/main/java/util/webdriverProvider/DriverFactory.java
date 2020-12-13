package util.webdriverProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.enums.BrowserType;
import util.helpers.PropertiesHandler;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

abstract class DriverFactory {

    @Getter
    public  static WebDriver driver;
    @Getter
    private static WebDriverWait waitDriver;
    @Getter
    protected static DriverFactory executor;

    public final static int PAGE_LOAD_TIMEOUT = 100;
    public final static int SHORT_TIME_FOR_THREAD = 1000;
    public final static int TIMEOUT = 60;
    public static String pageDefaultUrl;

    public DriverFactory(){
        driver = createDriver();
        pageDefaultUrl = PropertiesHandler.baseUri;
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static WebDriverWait getWaitDriver(){
        return waitDriver;
    }

    private static DesiredCapabilities getChromeCapabilities() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.directory_upgrade", true);
        chromePrefs.put("plugins.plugins_disabled", new String[]{"Chrome PDF Viewer"});

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-print-preview");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return capabilities;
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel,application/pdf");
        firefoxProfile.setPreference("pdfjs.disabled", true);
        firefoxProfile.setPreference("plugin.scan.Acrobat", "99.0");
        firefoxProfile.setPreference("plugin.scan.plid.all", false);

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(firefoxProfile);

        return firefoxOptions;
    }

    private static WebDriver createDriver(){
        BrowserType browserParameter = PropertiesHandler.browserParameter;

        switch (browserParameter) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(getFirefoxOptions());
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(getChromeCapabilities());
                break;
            default:
                throw new RuntimeException("unknown browser");
        }
        driver.manage().window().maximize();
        waitDriver = new WebDriverWait(driver, TIMEOUT);
        driver.manage().timeouts().pageLoadTimeout(DriverFactory.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }

    public static void setWaitDriverTimeOut(int timeout) {
        waitDriver = new WebDriverWait(driver, timeout);
    }


}
