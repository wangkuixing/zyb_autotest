package page.kfsjj;

import org.openqa.selenium.By;
import page.BasePage;

public class FhszPage extends BasePage {

    By jjmc=text("选择基金名称");
    By select=text("202016(南方300)");
    By fhfs=By.xpath("//android.widget.Spinner[@text='分红方式']");
    By xj=text("现金");
    By queding=text("确定");
    By ok=By.xpath("//android.widget.Button[@text='确定']");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By back=By.className("android.widget.ImageView");

    String message;

    public FhszPage jjFh(){

        find(jjmc).click();
        find(select).click();
        find(fhfs).click();
        find(xj).click();
        find(queding).click();
        find(ok).click();

        message=find(msg).getText();
        find(ok).click();
        return this;
    }

    public String getMessage(){
        return message;
    }

    public KfsjjPage gotoKfsjj(){

        waituntil(back);
        find(back).click();
        return new KfsjjPage();
    }
}
