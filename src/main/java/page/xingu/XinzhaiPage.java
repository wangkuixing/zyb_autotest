package page.xingu;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import page.YjdxPage;

public class XinzhaiPage extends BasePage {

    public XinzhaiPage xinzhaiTest() throws InterruptedException {
        By zwsj=text("暂无数据");

        Thread.sleep(5000);
        if (isElementExist(zwsj)){
            return this;
        } else{
            find(text("754421")).click();
            find(text("754313")).click();
            find(text("申购")).click();
            find(text("立即申购")).click();

            try{
                find(text("委托已提交"));
            }catch (NoSuchElementException e){}

            By qr=text("确认");
            waituntil(qr);
            find(qr).click();
            return this;
        }
    }

    public YjdxPage gotoYjdx() throws InterruptedException {
        By back=By.className("android.widget.ImageView");
        find(back).click();
        return new YjdxPage();
    }
}
