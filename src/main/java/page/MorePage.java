package page;

import org.openqa.selenium.By;

public class MorePage extends BasePage{
    By back=By.className("android.widget.ImageView");

    public CdbuyPage gotocdBuy() throws InterruptedException {
        find(text("拆单买入")).click();
        return new CdbuyPage();
    }

    public CdsalePage gotocdSale() throws InterruptedException {
        find(text("拆单卖出")).click();
        return new CdsalePage();
    }

    public TradePage gotoTrade() throws InterruptedException {
        find(back).click();
        return new TradePage();
    }
}
