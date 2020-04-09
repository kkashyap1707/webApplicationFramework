package webLoadTest.test.v1;

import de.sstoehr.harreader.HarReader;

import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;

import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;

import net.lightbody.bmp.proxy.CaptureType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SampleTest {

    // https://mvnrepository.com/artifact/edu.umass.cs.benchlab/harlib/1.1.2

    //https://mvnrepository.com/artifact/de.sstoehr/har-reader/2.1.7
    //https://github.com/sdstoehr/har-reader

    WebDriver driver;
    public static WebDriverWait wait;

    BrowserMobProxy proxy;
    public static Proxy seleniumProxy;

    public static String currentDirectory = System.getProperty("user.dir");
    public static String chromeDriverPath = currentDirectory + "/lib/chromedriver";
    public static String fileDownloadPath = currentDirectory + "/downloads";

    String workingDir = System.getProperty("user.dir");

    String filename = workingDir+"/PerformanceTestHar.har";
    String filename1 = workingDir+"/PerformanceTestHar.txt";
    String filename2 = workingDir+"/GIFparameters.txt";


    public static ChromeOptions chromePropertiesForPerformance(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY,seleniumProxy);

        Map<String, Object> prefsMap = new HashMap<String, Object>();
        prefsMap.put("profile.default_content_settings.popups", 0);
        prefsMap.put("download.default_directory", fileDownloadPath);

        ChromeOptions optionsForPerformance = new ChromeOptions().merge(capabilities);

        optionsForPerformance.setExperimentalOption("prefs", prefsMap);
        optionsForPerformance.setExperimentalOption("useAutomationExtension", false);
        optionsForPerformance.addArguments("--test-type");
        optionsForPerformance.addArguments("--disable-extensions");

        return optionsForPerformance;

    }

    public static Set<CaptureType> captureTypes(){

        Set<CaptureType> captureTypes = new HashSet<CaptureType>();
        captureTypes.add(CaptureType.REQUEST_BINARY_CONTENT);
        captureTypes.add(CaptureType.REQUEST_CONTENT);
        captureTypes.add(CaptureType.REQUEST_COOKIES);
        captureTypes.add(CaptureType.REQUEST_HEADERS);
        captureTypes.add(CaptureType.RESPONSE_BINARY_CONTENT);
        captureTypes.add(CaptureType.RESPONSE_CONTENT);
        captureTypes.add(CaptureType.RESPONSE_COOKIES);
        captureTypes.add(CaptureType.RESPONSE_HEADERS);


        return captureTypes;
    }

    @BeforeTest
    private void beforeTestAnalyticsData(){

        proxy = new BrowserMobProxyServer();
        proxy.setTrustAllServers(true);
        proxy.start();

        seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        proxy.enableHarCaptureTypes(captureTypes());
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver=new ChromeDriver(chromePropertiesForPerformance());
        driver.manage().window().maximize();

    }

    public static de.sstoehr.harreader.model.Har harReader(String harFilePath) throws HarReaderException {
        HarReader harReader = new HarReader();
        de.sstoehr.harreader.model.Har har = harReader.readFromFile(new File(harFilePath));

        return har;
    }

    @Test
    public void testAnalyticsData() throws IOException, HarReaderException {

        System.out.println("Current working directory : " + workingDir);

        proxy.newHar("Google");

        driver.get("https://www.google.com");
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        Har har = proxy.getHar();
        FileOutputStream fos = new FileOutputStream(filename);
        har.writeTo(fos);


        de.sstoehr.harreader.model.Har read = harReader(filename);

        Assert.assertNotNull(read);

        System.out.println(read.getLog().getVersion());
        System.out.println(read.getLog().getPages().get(0).getId());

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
