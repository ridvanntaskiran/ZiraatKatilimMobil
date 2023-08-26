package Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
AppiumDriver driver;
public WebDriverWait wait;

public BasePage(AppiumDriver driver){
    this.driver=driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(60) );
}
public WebElement findElement(By path){
    wait.until(ExpectedConditions.presenceOfElementLocated(path));
    return driver.findElement(path);
}
public void sendKeys(By path, String txt){
    findElement(path).sendKeys(txt);
}
public void click(By path)
{
    wait.until(ExpectedConditions.presenceOfElementLocated(path));
    findElement(path).click();
}
public void clear(By path){
    wait.until(ExpectedConditions.presenceOfElementLocated(path));
    findElement(path).clear();
}
    public String getText(By path) {
        wait.until(ExpectedConditions.presenceOfElementLocated(path));
        return findElement(path).getText();
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
