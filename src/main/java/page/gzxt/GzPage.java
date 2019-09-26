package page.gzxt;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class GzPage extends BasePage {

    By xjmr=text("限价买入");
    By xjmc=text("限价卖出");
    By gzcd=text("股转撤单");
    By back=By.className("android.widget.ImageView");

    public XjmrPage gotoXjmr() throws InterruptedException {

        find(xjmr).click();
        return new XjmrPage();
    }

    public XjmcPage gotoXjmc() throws InterruptedException {

        find(xjmc).click();
        return new XjmcPage();
    }

    public GzcdPage gotoGzcd() throws InterruptedException {

        find(gzcd).click();
        return new GzcdPage();
    }

    public TradePage gotoTrade() throws InterruptedException {

        find(back).click();
        return new TradePage();
    }
}
