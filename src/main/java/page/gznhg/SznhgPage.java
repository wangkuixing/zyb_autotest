package page.gznhg;

import org.openqa.selenium.By;
import page.BasePage;

public class SznhgPage extends BasePage {
    By amount=By.id("tzt_trade_linear_count_addcount_icon");
    By ljmc=text("立即卖出");
    By mc=text("卖出");
//    By msg=By.xpath("//android.widget.TextView[contains(@text, '委托')]");
    By msg=By.xpath("(//*/android.widget.TextView)[2]");
    By queding=text("确定");
    By back=By.xpath("//android.widget.Button[@text!='立即卖出']");
    By stkcode=By.id("com.ytsc:id/tzt_trade_edit_stockcode");
    String message1;
    String message2;

    public SznhgPage weituo1318xx() throws InterruptedException {
        find(amount).click();
        find(ljmc).click();
        find(mc).click();
        message1=find(msg).getText();
        find(queding).click();

        find(stkcode).sendKeys("131809");
        find(amount).click();
        find(ljmc).click();
        find(mc).click();
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

    public NhgPage gotoNhg() throws InterruptedException {
        find(back).click();
        return new NhgPage();
    }
}
