package Constants;
import org.openqa.selenium.By;

public class Constants {

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
}
