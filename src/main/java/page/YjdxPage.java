package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.xingu.XinguPage;
import page.xingu.XinzhaiPage;

public class YjdxPage extends BasePage{

    public XinguPage gotoXgsg() throws InterruptedException {
        find(text("新股申购")).click();
        return new XinguPage();
    }

    public XinzhaiPage gotoXinzhai() throws InterruptedException {
        By sg=text("债券申购");
        waituntil(sg);
        find(sg).click();
        return new XinzhaiPage();
    }

    public TradePage gotoTrade() throws InterruptedException {
        By back=By.className("android.widget.ImageView");
        find(back).click();
        return new TradePage();
    }
}
