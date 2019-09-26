package page.cnjj;

import org.openqa.selenium.By;
import page.BasePage;

public class CnjjPage extends BasePage {
    By cnrg=text("场内认购");
    By cnsg=text("场内申购");
    By cnsh=text("场内赎回");

    public CnjjrgPage gotoRg() throws InterruptedException {
        find(cnrg).click();
        return new CnjjrgPage();
    }

    public CnjjsgPage gotoSg() throws InterruptedException {
        find(cnsg).click();
        return new CnjjsgPage();
    }

    public CnjjshPage gotoSh() throws InterruptedException {
        find(cnsh).click();
        return new CnjjshPage();
    }
}
