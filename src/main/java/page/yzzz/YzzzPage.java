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

    public ZjzrPage gotoZjzr(){

        find(zjzr).click();
        return new ZjzrPage();
    }

    public ZjzcPage gotoZjzc(){

        find(zjzc).click();
        return new ZjzcPage();
    }

    public WdzjPage gotoWdzj(){

        find(wdzj).click();
        return new WdzjPage();
    }

    public YhyePage gotoYhye(){

        find(yhye).click();
        return new YhyePage();
    }

    public ZjgjPage gotoZjgj(){

        find(zjgj).click();
        return new ZjgjPage();
    }

    public ZjdbPage gotoZjdb(){

        find(zjdb).click();
        return new ZjdbPage();
    }

    public TradePage gotoTrade(){

        find(back).click();
        return new TradePage();
    }
}
