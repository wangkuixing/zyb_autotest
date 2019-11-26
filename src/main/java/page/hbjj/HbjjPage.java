package page.hbjj;

import org.openqa.selenium.By;
import page.BasePage;

public class HbjjPage extends BasePage {
    By jjsg=text("基金申购");
    By jjsh=text("基金赎回");

    public HbjjsgPage gotoSg() throws InterruptedException {
        find(jjsg).click();
        return new HbjjsgPage();
    }

    public HbjjshPage gotoSh() throws InterruptedException {
        find(jjsh).click();
        return new HbjjshPage();
    }
}
