package webLoadTest.test.v1;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webLoadTest.test.TestBaseBrowser;
import webLoadTest.utilities.*;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SampleTest {

    WebDriver driver;
    public static WebDriverWait wait;
    BrowserMobProxy proxy;
    public static String currentDirectory = System.getProperty("user.dir");
    public static String chromeDriverPath = currentDirectory + "/lib/chromedriver";
    public static String fileDownloadPath = currentDirectory + "/downloads";



    @BeforeTest
    private void beforeTestAnalyticsData(){

        proxy = new BrowserMobProxyServer();
        proxy.setTrustAllServers(true);
        proxy.start();

        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        Set<CaptureType> captureTypes = new HashSet<CaptureType>();
        captureTypes.add(CaptureType.REQUEST_BINARY_CONTENT);
        captureTypes.add(CaptureType.REQUEST_CONTENT);
        captureTypes.add(CaptureType.REQUEST_COOKIES);
        captureTypes.add(CaptureType.REQUEST_HEADERS);
        captureTypes.add(CaptureType.RESPONSE_BINARY_CONTENT);
        captureTypes.add(CaptureType.RESPONSE_CONTENT);
        captureTypes.add(CaptureType.RESPONSE_COOKIES);
        captureTypes.add(CaptureType.RESPONSE_HEADERS);

        proxy.enableHarCaptureTypes(captureTypes);


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY,seleniumProxy);

        Map<String, Object> prefsMap = new HashMap<String, Object>();
        prefsMap.put("profile.default_content_settings.popups", 0);
        prefsMap.put("download.default_directory", fileDownloadPath);

        ChromeOptions option = new ChromeOptions().merge(capabilities);

        option.setExperimentalOption("prefs", prefsMap);
        option.setExperimentalOption("useAutomationExtension", false);
        option.addArguments("--test-type");
        option.addArguments("--disable-extensions");


        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver=new ChromeDriver(option);

        driver.manage().window().maximize();

    }

    @Test
    public void testAnalyticsData() throws IOException {

        /*
         * Giving a har name
         */
        proxy.newHar("Google");

        driver.get("https://www.google.com");
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        /*
         * Get the all network traffic.
         */
        Har har = proxy.getHar();

        /*
         * Store it in a .har file.
         */
        File harFile = new File("./Google.har");
        har.writeTo(harFile);
    }

    @AfterTest
    private void afterTestAnalyticsData() {
        if (driver != null) {
            driver.quit();
        } else if (proxy.isStarted()) {
            proxy.stop();
        }
    }

}
