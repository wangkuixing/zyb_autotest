package page.ggt;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

public class VoteggPage extends BasePage {
    By hgt=text("沪港通公司投票申报");
    By sgt=text("深港通公司投票申报");
    String none="暂无可选议案编号";
    By yabh=By.xpath("//android.view.View[5]/android.view.View[2]/android.widget.Spinner");
    By zcsl=By.xpath("//android.view.View[6]/android.view.View[2]/android.widget.EditText");
    By fdsl=By.xpath("//android.view.View[7]/android.view.View[2]/android.widget.EditText");
    By qqsl=By.xpath("//android.view.View[8]/android.view.View[2]/android.widget.EditText");
    By tpsb=text("投票申报");
    By queding=text("确定");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By back=By.className("android.widget.ImageView");
    String message1;
    String message2;

    public VoteggPage voteHgt() throws InterruptedException {
        find(hgt).click();
        waituntil(yabh);
        if (find(yabh).getText().contains(none)){
            find(back).click();
            message1=none;
        }
        else
        {
            find(zcsl).sendKeys("1");
            find(tpsb).click();
            find(queding).click();
            message1=find(msg).getText();
            find(queding).click();
            find(back).click();
        }
        return this;
    }

    public VoteggPage voteSgt() throws InterruptedException {
        find(sgt).click();
        waituntil(yabh);
        if (find(yabh).getText().contains(none)){
            find(back).click();
            message2=none;
        }
        else
        {
            find(zcsl).sendKeys("1");
            find(tpsb).click();
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
