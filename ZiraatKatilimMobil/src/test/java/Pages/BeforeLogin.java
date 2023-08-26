package Pages;

import Base.BasePage;
import Constants.Constants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BeforeLogin extends BasePage {

    AppiumDriver driver;
    Constants constants= new Constants();

    public BeforeLogin(AppiumDriver driver) {
        super(driver);
    }
    public BeforeLogin allowNotifications(){
        wait.until(ExpectedConditions.presenceOfElementLocated(constants.allowButton));
        click(constants.allowButton);
        return this;
    }
    public BeforeLogin passSplashScreen(){
        wait.until(ExpectedConditions.presenceOfElementLocated(constants.skipButton));
        click(constants.skipButton);
        return this;
    }
    public BeforeLogin allowPhoneCalls() {
        wait.until(ExpectedConditions.presenceOfElementLocated(constants.allowButton));
        click(constants.allowButton);
        return this;
    }

    public BeforeLogin extendBeforeLoginMoreSection() {
        wait.until(ExpectedConditions.presenceOfElementLocated(constants.dragButton));
        click(constants.dragButton);
        return this;
    }

    public BeforeLogin openFinancementPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(constants.calculationTools));
        click(constants.calculationTools);
        swipeToRight();
        click(constants.financementCalculation);
        return this;
    }
    public BeforeLogin financementPageActivities() {
        wait.until(ExpectedConditions.presenceOfElementLocated(constants.vehicle));
        click(constants.vehicle);
        wait.until(ExpectedConditions.presenceOfElementLocated(constants.financementTime));
        click(constants.financementTime);
        click(constants.twelveMonth);
        click(constants.financementAmount);
        sendKeys(constants.financementAmount,"10000");
        click(constants.calculateButton);
        return this;
    }




}
