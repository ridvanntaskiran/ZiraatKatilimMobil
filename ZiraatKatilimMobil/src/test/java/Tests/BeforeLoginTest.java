package Tests;
import Base.BaseTest;
import Pages.BeforeLogin;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeLoginTest extends BaseTest {
    BeforeLogin beforelogin;
    @BeforeClass
    public void before(){
        beforelogin= new BeforeLogin(getAppiumDriver());

    }

    @Test
    public void test() throws InterruptedException {

        beforelogin
                .allowNotifications()
                .passSplashScreen()
                .allowPhoneCalls()
                .extendBeforeLoginMoreSection()
                .openFinancementPage()
                .financementPageActivities();
        Thread.sleep(3000);
    }
    @AfterClass
    public void after(){

       tearDown();

    }
}
