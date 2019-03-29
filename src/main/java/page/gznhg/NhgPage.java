package page.gznhg;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class NhgPage extends BasePage {

    public SznhgPage gotoSz(){
        find(text("Ｒ-001 131810")).click();

        return new SznhgPage();
    }

    public ShnhgPage gotoSh(){

        find(text("沪市(10万元起)")).click();
        find(text("GC001 204001")).click();

        return new ShnhgPage();
    }

    public TradePage gotoTrade(){

        By back=By.className("android.widget.ImageView");
        find(back).click();

        return new TradePage();
    }
}
