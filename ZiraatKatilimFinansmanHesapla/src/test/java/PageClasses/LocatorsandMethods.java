package PageClasses;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;



public class LocatorsandMethods {
    public static AppiumDriver driver;
    public static WebDriverWait wait;

    public By allowButton = By.id("com.android.permissioncontroller:id/permission_allow_button");
    public By skipButton = By.id("com.ziraatkatilim.mobilebanking:id/skip_button");
    public By dragButton = By.id("com.ziraatkatilim.mobilebanking:id/bottom_bar_drag_button");
    public By calculationTools = By.xpath("//android.widget.TextView[@text='HESAPLAMA ARAÇLARI']");
    public By financementCalculation = By.xpath("//android.widget.TextView[@text='Finansman Hesaplama']");
    public By vehicle = By.xpath("//android.widget.TextView[@text='Araç']");
    public By financementTime = By.xpath("//android.widget.TextView[@text='Finansman Vadesi']");
    public By twelveMonth = By.xpath("//android.widget.TextView[@text='12 Ay']");
    public By financementAmount = By.id("com.ziraatkatilim.mobilebanking:id/amount");
    public By calculateButton = By.xpath("//android.widget.Button[@text='HESAPLA']");

    public static void initializeDriver() {

        try {
            org.openqa.selenium.remote.DesiredCapabilities capabilities = new org.openqa.selenium.remote.DesiredCapabilities();
            capabilities.setCapability("deviceName", "Nexus 5 API UpsideDownCakePrivacySandbox");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "emulator-5556");
            capabilities.setCapability("platformVersion", "UpsideDownCakePrivacySendbox");
            capabilities.setCapability("appPackage", "com.ziraatkatilim.mobilebanking");
            capabilities.setCapability("appActivity", "com.ziraatkatilim.mobilebanking.Controller.BeforeLogin.SplashController");
            //capabilities.setCapability("appActivity", "com.ziraatkatilim.mobilebanking.Controller.BeforeLogin.Calculation.CalculationToolsController");
            capabilities.setCapability("skipUnlock", "true");
            capabilities.setCapability("noReset", "false"); // Added this capability
            capabilities.setCapability("automationName", "UiAutomator2"); // Added this capability

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        } catch (MalformedURLException mx) {
            System.out.println("Hatalı oluşturulmuş URL istisnası!");
        }
    }

        public void quitDriver() {
            if (driver != null) {
                driver.quit();
            }

        }


    public void findAndClickElement(By locator) {
        //initializeDriver();  // Eğer zaten bir driver iniz varsa bu satırı kullanmanıza gerek olmayabilir
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement clickedElement = driver.findElement(locator);
        clickedElement.click();
    }

    public void swipeToRight() {
        Dimension screenSize = driver.manage().window().getSize();
        int screenWidth = screenSize.getWidth();
        int screenHeight = screenSize.getHeight();

        // Define start and end points for the swipe (right direction)
        int startX = screenWidth * 3 / 4; // Starting from 3/4th of the screen horizontally
        int startY = screenHeight / 2;    // Middle of the screen vertically
        int endX = screenWidth / 8;       // 1/4th from the left horizontally

        // Create a TouchAction instance and perform the swipe
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.press(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, startY))
                .release()
                .perform();

    }

}
