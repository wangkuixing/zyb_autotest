package page.kfsjj;

import org.openqa.selenium.By;
import page.BasePage;

public class JjzhPage extends BasePage {
    By zcjj=text("选择转出基金");
    By select=text("202015(南方300)");
    By zrjj=By.xpath("//android.view.View[5]/android.view.View[2]/android.widget.EditText");
    By zhfe=By.xpath("//android.view.View[8]/android.view.View[2]/android.widget.EditText");
    By queding=text("确定");
    By ok=By.xpath("//android.widget.Button[@text='确定']");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By back=By.className("android.widget.ImageView");
    String message;

    public JjzhPage jjZh(String stkcode, String amount) throws InterruptedException {
        find(zcjj).click();
        find(select).click();
        find(zrjj).sendKeys(stkcode);
        waituntil(zhfe);
        find(zhfe).sendKeys(amount);
        find(queding).click();
        find(ok).click();

        message=find(msg).getText();
        find(ok).click();
        return this;
    }

    public String getMessage(){
        return message;
    }

    public KfsjjPage gotoKfsjj() throws InterruptedException {
        waituntil(back);
        find(back).click();
        return new KfsjjPage();
    }
}
