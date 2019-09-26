package page.kfsjj;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class KfsjjPage extends BasePage {

    By jjsg=text("基金申购");
    By jjsh=text("基金赎回");
    By jjrg=text("基金认购");
    By cxwt=text("撤销委托");
    By fhsz=text("分红设置");
    By jjzh=text("基金转换");
    By dt=text("定投登记");
    By dtqx=text("定投取消");
    By back=By.className("android.widget.ImageView");

    public JjsgPage gotoJjsg() throws InterruptedException {

        find(jjsg).click();
        return new JjsgPage();
    }

    public JjshPage gotoJjsh() throws InterruptedException {

        find(jjsh).click();
        return new JjshPage();
    }

    public JjrgPage gotoJjrg() throws InterruptedException {

        find(jjrg).click();
        return new JjrgPage();
    }

    public JjcdPage gotoJjcd() throws InterruptedException {

        find(cxwt).click();
        return new JjcdPage();
    }
    public FhszPage gotoFhsz() throws InterruptedException {

        find(fhsz).click();
        return new FhszPage();
    }

    public JjzhPage gotoJjzh() throws InterruptedException {

        find(jjzh).click();
        return new JjzhPage();
    }

    public JjdtPage gotoJjdt() throws InterruptedException {

        find(dt).click();
        return new JjdtPage();
    }

    public JjdtqxPage gotoJjdtqx() throws InterruptedException {

        find(dtqx).click();
        return new JjdtqxPage();
    }

    public TradePage gotoTrade() throws InterruptedException {

        find(back).click();
        return new TradePage();
    }
}
