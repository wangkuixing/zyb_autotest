package page.gzxt;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class XjmcPage extends BasePage {

    By stockedit=By.id("tzt_trade_edit_stockcode");
    By buyamount=By.id("tzt_trade_linear_count_addcount_icon");
    By xjmc=text("限价卖出");
    By mc=By.xpath("//android.widget.Button[@text='卖出']");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By queding=text("确定");
    By back=By.xpath("//android.widget.Button[@text!='限价卖出']");

    String message;

    public XjmcPage saleGz(String stockcode){

        find(stockedit).sendKeys(stockcode);
        find(buyamount).click();
        find(xjmc).click();
        find(mc).click();
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
