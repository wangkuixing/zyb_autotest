package page.kfsjj;

import org.openqa.selenium.By;
import page.BasePage;

public class JjdtqxPage extends BasePage {

    By jjdm=By.xpath("//android.view.View[1]/android.view.View[2]/android.widget.Spinner");
    By id=By.id("android:id/text1");
    By select=By.xpath("//*[@resource-id='android:id/text1' and contains(@text, '000562')]");
    By dtje=By.xpath("//android.view.View[6]/android.view.View[2]/android.widget.EditText");
    By queding=text("确定");
    By ok=By.xpath("//android.widget.Button[@text='确定']");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By back=By.className("android.widget.ImageView");

    String message;

    public JjdtqxPage jjDtqx() throws InterruptedException {

        find(jjdm).click();
        if (find(id).getText().contains("000562")){
            find(select).click();
            find(queding).click();
            find(ok).click();

            message=find(msg).getText();
            find(ok).click();
            return this;
        }else{
            find(id).click();
            message="无定投委托";
            return this;
        }
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
