package page.kfsjj;

import org.openqa.selenium.By;
import page.BasePage;

public class JjrgPage extends BasePage {
    By jjdm=By.xpath("//android.view.View[2]/android.view.View[2]/android.widget.EditText");
    By rgje=By.xpath("//android.view.View[3]/android.view.View[2]/android.widget.EditText");
    By queding=text("确定");
    By nike=By.xpath("//android.view.View[10]/android.view.View[2]/android.view.View[3]");
    By queren=By.xpath("//android.view.View[2]/android.view.View[2]");
    By confirm=By.xpath("//android.view.View[10]/android.view.View[3]/android.view.View[2]");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By ok=By.xpath("//android.widget.Button[@text='确定']");
    By back=By.className("android.widget.ImageView");
    String message;

    public JjrgPage jjRg(String stockcode, String amount) throws InterruptedException {
        find(jjdm).sendKeys(stockcode);
        find(rgje).sendKeys(amount);
        find(queding).click();
        find(nike).click();
        waituntil(queren);
        find(queren).click();
        find(confirm).click();

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
