package page.cnjj;

import org.openqa.selenium.By;
import page.BasePage;
import page.hbjj.HbjjPage;
import page.hbjj.HbjjsgPage;

public class CnjjrgPage extends BasePage {

    By jjdm=By.xpath("//android.view.View[1]/android.view.View[2]/android.widget.EditText");
    By rgfe=By.xpath("//android.view.View[3]/android.view.View[2]/android.widget.EditText");
    By queding=text("确定");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By ok=By.xpath("//android.widget.Button[@text='确定']");
    By back=By.className("android.widget.ImageView");

    String message;


    public CnjjrgPage jjRg(String stockcode, String amount) throws InterruptedException {

        find(jjdm).sendKeys(stockcode);
        find(rgfe).sendKeys(amount);
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

    public CnjjPage gotoCnjj() throws InterruptedException {

        waituntil(back);
        find(back).click();
        return new CnjjPage();
    }

}
