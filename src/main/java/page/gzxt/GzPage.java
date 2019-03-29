package page.gzxt;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class GzPage extends BasePage {

    By xjmr=text("限价买入");
    By xjmc=text("限价卖出");
    By gzcd=text("股转撤单");
    By back=By.className("android.widget.ImageView");

    public XjmrPage gotoXjmr(){

        find(xjmr).click();
        return new XjmrPage();
    }

    public XjmcPage gotoXjmc(){

        find(xjmc).click();
        return new XjmcPage();
    }

    public GzcdPage gotoGzcd(){

        find(gzcd).click();
        return new GzcdPage();
    }

    public TradePage gotoTrade(){

        find(back).click();
        return new TradePage();
    }
}
