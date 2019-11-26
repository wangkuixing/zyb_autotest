package page.kfsjj;

import org.openqa.selenium.By;
import page.BasePage;

public class JjdtPage extends BasePage {
    By zcjj=text("选择转出基金");
    By select=text("202015(南方300)");
    By jjdm=By.xpath("//android.view.View[3]/android.view.View[2]/android.widget.EditText");
    By dtje=By.xpath("//android.view.View[6]/android.view.View[2]/android.widget.EditText");
    By queding=text("确定");
    By ok=By.xpath("//android.widget.Button[@text='确定']");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By back=By.className("android.widget.ImageView");
    String message;

    public JjdtPage jjDt(String stkcode, String amount) throws InterruptedException {
        find(jjdm).sendKeys(stkcode);
        find(dtje).sendKeys(amount);
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
