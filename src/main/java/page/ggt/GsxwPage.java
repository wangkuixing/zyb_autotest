package page.ggt;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

public class GsxwPage extends BasePage {
    By hgt=text("沪港通公司行为申报");
    By sgt=text("深港通公司行为申报");
    By xwdm=By.xpath("//android.view.View[6]/android.view.View[2]/android.widget.Spinner");
    String none="无可选行为代码";
    By sbsl=By.xpath("//android.view.View[7]/android.view.View[2]/android.widget.EditText");
    By sb=By.xpath("//android.view.View[@text='申报']");
    By queding=text("确定");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By back=By.className("android.widget.ImageView");
    String message1;
    String message2;

    public GsxwPage gsxwHgt() throws InterruptedException {
        find(hgt).click();
        waituntil(xwdm);
        if (find(xwdm).getText().contains(none)){
            find(back).click();
            message1=none;
        }
        else
        {
            find(sbsl).sendKeys("1");
            find(sb).click();
            find(queding).click();
            message1=find(msg).getText();
            find(queding).click();
            find(back).click();
        }
        return this;
    }


    public GsxwPage gsxwSgt() throws InterruptedException {
        find(sgt).click();
        waituntil(xwdm);
        if (find(xwdm).getText().contains(none)){
            find(back).click();
            message2=none;
        }
        else
        {
            find(sbsl).sendKeys("1");
            find(sb).click();
            find(queding).click();
            message2=find(msg).getText();
            find(queding).click();
            find(back).click();
        }
        return this;
    }

    public String getMessage1(){
        return message1;
    }

    public String getMessage2(){
        return message2;
    }

    public GgtPage gotoGgt() throws InterruptedException {
        find(back).click();
        return new GgtPage();
    }
}
