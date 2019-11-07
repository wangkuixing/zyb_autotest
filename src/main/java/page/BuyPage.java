package page;

import driver.Driver;
import org.openqa.selenium.By;

public class BuyPage extends BasePage{

    By stockedit=By.id("tzt_trade_edit_stockcode");
    By buyamount=By.id("tzt_trade_linear_count_addcount_icon");
    By ljmr=text("立即买入");
    By mr=text("买入");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By queding=text("确定");
    By back=By.xpath("//android.widget.Button[@text!='立即买入']");
//    By back=By.xpath("//android.widget.Button");

    String message;


    public BuyPage buyTest(String stockcode) throws InterruptedException {

        find(stockedit).sendKeys(stockcode);
        find(buyamount).click();
        find(ljmr).click();
        find(mr).click();
        message=find(msg).getText();
        find(queding).click();

        return this;
    }

    public String getMessage(){
        return message;
    }

    public TradePage gotoTrade() throws InterruptedException {

        waituntil(back);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        find(back).click();
//        Driver.getCurrentDriver().findElements(back).get(0).click();
        return new TradePage();
    }
}
