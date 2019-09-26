package page.yzzz;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class YzzzPage extends BasePage {

    By zjzr=text("资金转入");
    By zjzc=text("资金转出");
    By wdzj=text("我的资金");
    By yhye=text("银行余额");
    By zjgj=text("资金归集");
    By zjdb=text("资金调拨");
    By back=By.className("android.widget.ImageView");

    public ZjzrPage gotoZjzr() throws InterruptedException {

        find(zjzr).click();
        return new ZjzrPage();
    }

    public ZjzcPage gotoZjzc() throws InterruptedException {

        find(zjzc).click();
        return new ZjzcPage();
    }

    public WdzjPage gotoWdzj() throws InterruptedException {

        find(wdzj).click();
        return new WdzjPage();
    }

    public YhyePage gotoYhye() throws InterruptedException {

        find(yhye).click();
        return new YhyePage();
    }

    public ZjgjPage gotoZjgj() throws InterruptedException {

        find(zjgj).click();
        return new ZjgjPage();
    }

    public ZjdbPage gotoZjdb() throws InterruptedException {

        find(zjdb).click();
        return new ZjdbPage();
    }

    public TradePage gotoTrade() throws InterruptedException {

        find(back).click();
        return new TradePage();
    }
}
