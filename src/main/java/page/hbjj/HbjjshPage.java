package page.hbjj;

import org.openqa.selenium.By;
import page.BasePage;

public class HbjjshPage extends BasePage {

    By jjdm=By.xpath("//android.view.View[1]/android.view.View[2]/android.widget.EditText");
    By shfe=By.xpath("//android.view.View[3]/android.view.View[2]/android.widget.EditText");
    By queding=text("确定");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By ok=By.xpath("//android.widget.Button[@text='确定']");
    By back=By.className("android.widget.ImageView");

    String message;


    public HbjjshPage jjSh(String stockcode, String amount){

        find(jjdm).sendKeys(stockcode);
        find(shfe).sendKeys(amount);
        find(queding).click();
        waituntil(ok);
        find(ok).click();

        message=find(msg).getText();
        find(ok).click();
        return this;
    }

    public String getMessage(){
        return message;
    }

    public HbjjPage gotoHbjj(){

        waituntil(back);
        find(back).click();
        return new HbjjPage();
    }
}
