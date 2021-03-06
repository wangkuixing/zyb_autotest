package page.yzzz;

import org.openqa.selenium.By;
import page.BasePage;

public class ZjzcPage extends BasePage {
    By zzje=By.xpath("//android.view.View[6]/android.view.View[3]/android.widget.EditText");
    By yhmm=By.xpath("//android.view.View[7]/android.view.View[2]/android.widget.EditText");
    By ljzz=text("立即转账");
    By queding=text("确定");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By back=By.className("android.widget.ImageView");
    String message;

    public ZjzcPage zqtoYh() throws InterruptedException {
        find(zzje).sendKeys("222");
        find(yhmm).sendKeys("123321");
        find(ljzz).click();
        find(queding).click();
        message=find(msg).getText();
        find(queding).click();
        return this;
    }

    public String getMessage(){
        return message;
    }

    public YzzzPage gotoYzzz() throws InterruptedException {
        find(back).click();
        return new YzzzPage();
    }
}
