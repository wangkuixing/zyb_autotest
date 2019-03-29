package page.gzxt;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class XjmrPage extends BasePage {

    By stockedit=By.id("tzt_trade_edit_stockcode");
    By buyamount=By.id("tzt_trade_linear_count_addcount_icon");
    By xjmr=text("限价买入");
    By nike=By.className("android.widget.CheckBox");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By queding=text("确定");
    By back=By.xpath("//android.widget.Button[@text!='限价买入']");

    String message;


    public XjmrPage buyGz(String stockcode){

        find(stockedit).sendKeys(stockcode);
        find(buyamount).click();
        find(xjmr).click();
        find(nike).click();
        find(queding).click();
        message=find(msg).getText();
        find(queding).click();

        return this;
    }

    public String getMessage(){
        return message;
    }

    public GzPage gotoGz(){

        waituntil(back);
        find(back).click();
        return new GzPage();
    }
}
