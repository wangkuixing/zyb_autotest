package page.ggt;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class GgtPage extends BasePage {

    public BuyggtPage gotoBuy(){
        find(text("港股通买入")).click();

        return new BuyggtPage();
    }

    public SaleggtPage gotoSale(){

        find(text("港股通卖出")).click();

        return new SaleggtPage();
    }

    public GgchedanPage gotoChedan(){

        find(text("港股撤单")).click();

        return new GgchedanPage();
    }

    public VoteggPage gotoVote(){

        find(text("投票申报")).click();

        return new VoteggPage();
    }

    public GsxwPage gotoGsxx(){

        find(text("公司行为")).click();

        return new GsxwPage();
    }

    public TradePage gotoTrade(){

        By back=By.className("android.widget.ImageView");
        find(back).click();

        return new TradePage();
    }
}
