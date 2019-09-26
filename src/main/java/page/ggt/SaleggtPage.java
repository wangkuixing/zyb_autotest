package page.ggt;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import page.SalePage;
import page.TradePage;

public class SaleggtPage extends BasePage {

    By stockedit=By.id("tzt_trade_edit_stockcode");
    //By hgtacct=text("A445206425 (沪HK)");
    By hgtacct=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By stockamount=By.id("tzt_trade_linear_count_addcount_icon");
    By ljmc=text("立即卖出");
    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By queding=text("确定");
    By back=By.xpath("//android.widget.Button[@text!='立即卖出']");

    String message;

    public SaleggtPage saleHgt(String stockcode) throws InterruptedException {

        find(stockedit).sendKeys(stockcode);
        find(hgtacct).click();
        find(this.stockamount).click();
        find(ljmc).click();
        find(queding).click();

        WebDriverWait wait=new WebDriverWait(Driver.getCurrentDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(msg));
        message=find(msg).getText();
        find(queding).click();

        return new SaleggtPage();
    }

    public SaleggtPage saleSgt(String stockcode) throws InterruptedException {

        find(stockedit).sendKeys(stockcode);
        find(this.stockamount).click();
        find(ljmc).click();
        find(queding).click();

        WebDriverWait wait=new WebDriverWait(Driver.getCurrentDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(msg));
        message=find(msg).getText();
        find(queding).click();

        return new SaleggtPage();
    }


    public String getMessage(){
        return message;
    }

    public GgtPage gotoGgt() throws InterruptedException {

        find(back).click();

        return new GgtPage();
    }
}
