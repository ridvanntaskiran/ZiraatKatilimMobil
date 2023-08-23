package org.example;
import PageClasses.LocatorsandMethods;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FinancementCalculation {
   LocatorsandMethods locatorsandMethods =new LocatorsandMethods();


    public static AppiumDriver driver;
    public WebDriverWait wait;


    @BeforeTest
    public void beforeTest() {

        locatorsandMethods.initializeDriver();
        driver = locatorsandMethods.driver; // Get the driver instance from LocatorsandMethods
        wait = locatorsandMethods.wait;

    }
    @AfterTest
    public void tearDown() {
        locatorsandMethods.quitDriver();
    }

    @Test
    public void test() throws InterruptedException {


        locatorsandMethods.findAndClickElement(locatorsandMethods.allowButton);
        locatorsandMethods.findAndClickElement(locatorsandMethods.skipButton);
        locatorsandMethods.findAndClickElement(locatorsandMethods.allowButton);
        locatorsandMethods.findAndClickElement(locatorsandMethods.dragButton);
        locatorsandMethods.findAndClickElement(locatorsandMethods.calculationTools);

       locatorsandMethods.swipeToRight();

        locatorsandMethods.findAndClickElement(locatorsandMethods.financementCalculation);
        locatorsandMethods.findAndClickElement(locatorsandMethods.vehicle);
        locatorsandMethods.findAndClickElement(locatorsandMethods.financementTime);
        locatorsandMethods.findAndClickElement(locatorsandMethods.twelveMonth);

        WebElement financementAmountt= driver.findElement(locatorsandMethods.financementAmount);
        //double amount = 1000.0;
        //String amountt= Double.toString(amount);
        financementAmountt.sendKeys("10000");
        System.out.println("Finansman alanı değeri: " + financementAmountt.getAttribute("text"));
        Thread.sleep(3000);
        locatorsandMethods.findAndClickElement(locatorsandMethods.calculateButton);
        Thread.sleep(3000);



    }
}
