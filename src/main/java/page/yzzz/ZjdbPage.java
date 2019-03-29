package page.yzzz;

import org.openqa.selenium.By;
import page.BasePage;

public class ZjdbPage extends BasePage {

    By zrzh=By.xpath("//android.view.View[4]/android.view.View[2]/android.widget.Spinner");
    By mscg=text("（1200106828）民生存管");
    By zzje=By.className("android.widget.EditText");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By queding=text("确定");
    By queding2=By.xpath("//android.widget.Button[@text='确定']");
    By back=By.className("android.widget.ImageView");


    String message;

    public ZjdbPage zjDb(){

        find(zrzh).click();
        find(mscg).click();
        find(zzje).sendKeys("333");
        find(queding).click();
        find(queding2).click();
        message=find(msg).getText();
        find(queding2).click();
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

