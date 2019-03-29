package page.yzzz;

import org.openqa.selenium.By;
import page.BasePage;

public class ZjgjPage extends BasePage {

    By zjgj=By.xpath("//android.view.View[@text='资金归集']");
    By zjgjqr=By.xpath("//android.view.View[5]/android.view.View[4]/android.view.View[2]");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By queding=text("确定");
    By back=By.className("android.widget.ImageView");


    String message;

    public ZjgjPage zjGj(){

        find(zjgj).click();
        find(zjgjqr).click();
        message=find(msg).getText();
        find(queding).click();
        return this;
    }

    public String getMessage(){

        return message;
    }

    public YzzzPage gotoYzzz(){
        find(back).click();
        return new YzzzPage();
    }
}
