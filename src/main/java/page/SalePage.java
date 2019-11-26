package page;

import org.openqa.selenium.By;

public class SalePage extends BasePage{
    By stockedit=By.id("tzt_trade_edit_stockcode");
    //By stockamount=text("委托数量");
    By stockamount=By.id("tzt_trade_linear_count_addcount_icon");
    By ljmc=text("立即卖出");
    By mc=text("卖出");
    By msg=By.xpath("//android.widget.TextView[contains(@text, '委托')]");
    By queding=text("确定");
    By back=By.xpath("//android.widget.Button[@text!='立即卖出']");
    String message;

    public SalePage SaleTest(String stockcode, String stockamount) throws InterruptedException {
        find(stockedit).sendKeys(stockcode);
        //find(this.stockamount).sendKeys(stockamount);
        //等待10s取股东号，证券信息
        find(this.stockamount).click();
        find(ljmc).click();
        find(mc).click();
        message=find(msg).getText();
        find(queding).click();

        return new SalePage();
    }

    public String getMessage(){
        return message;
    }

    public TradePage gotoTrade() throws InterruptedException {
        find(back).click();
        return new TradePage();
    }
}
