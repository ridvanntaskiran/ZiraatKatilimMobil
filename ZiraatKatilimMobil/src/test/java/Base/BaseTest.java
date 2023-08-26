package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class BaseTest {

    static AppiumDriver appiumDriver = null;
    public static WebDriverWait wait;

    @BeforeClass
    public void setUp(){

        try {
            org.openqa.selenium.remote.DesiredCapabilities capabilities = new org.openqa.selenium.remote.DesiredCapabilities();
            capabilities.setCapability("deviceName", "Nexus 5 API UpsideDownCakePrivacySandbox");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "emulator-5554");
            capabilities.setCapability("platformVersion", "UpsideDownCakePrivacySendbox");
            capabilities.setCapability("appPackage", "com.ziraatkatilim.mobilebanking");
            capabilities.setCapability("appActivity", "com.ziraatkatilim.mobilebanking.Controller.BeforeLogin.SplashController");
            //capabilities.setCapability("appActivity", "com.ziraatkatilim.mobilebanking.Controller.BeforeLogin.Calculation.CalculationToolsController");
            capabilities.setCapability("skipUnlock", "true");
            capabilities.setCapability("noReset", "false"); // Added this capability
            capabilities.setCapability("automationName", "UiAutomator2"); // Added this capability

            appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));
        } catch (MalformedURLException mx) {
            System.out.println("Hatalı oluşturulmuş URL istisnası!");
        }
    }
    public static AppiumDriver getAppiumDriver(){
return appiumDriver;
    }
public static void setAppiumDriver(AppiumDriver appiumDriver){
        BaseTest.appiumDriver=appiumDriver;
}

public void tearDown(){
        getAppiumDriver().quit();
}
    }


