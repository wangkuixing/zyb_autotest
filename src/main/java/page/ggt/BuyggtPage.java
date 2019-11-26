package page.ggt;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;


public class BuyggtPage extends BasePage {
    By stockedit=By.id("tzt_trade_edit_stockcode");
    //By hgtacct=text("A445206425 (沪HK)");
    By hgtacct=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    //By sgtacct=text("0128208140 (深HK)");
    By sgtacct=By.xpath("//android.widget.LinearLayout[1]/android.widget.TextView");
    By buyamount=By.id("tzt_trade_linear_count_addcount_icon");
    By ljmr=text("立即买入");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By queding=text("确定");
    By back=By.xpath("//android.widget.Button[@text!='立即买入']");
    String message1;
    String message2;


    public BuyggtPage buyHgt(String stockcode) throws InterruptedException {
        find(stockedit).sendKeys(stockcode);
        find(hgtacct).click();
        find(buyamount).click();
        find(ljmr).click();
        find(queding).click();
        waituntil(msg);
        message1=find(msg).getText();
        find(queding).click();

        return this;
    }

    public BuyggtPage buySgt(String stockcode) throws InterruptedException {
        find(stockedit).sendKeys(stockcode);
        find(sgtacct).click();
        find(buyamount).click();
        find(ljmr).click();
        find(queding).click();
        waituntil(msg);
        message2=find(msg).getText();
        find(queding).click();

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
