package page.xingu;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import page.YjdxPage;

public class XinguPage extends BasePage{

    public  XinguPage xinguTest() throws InterruptedException {
        By sg=text("申购");
        By zwsj=text("暂无数据");

        Thread.sleep(5000);
        if (isElementExist(zwsj)){
            return this;
        } else{
            WebDriverWait wait=new WebDriverWait(Driver.getCurrentDriver(),10);
            wait.until(ExpectedConditions.presenceOfElementLocated(sg));
            find(sg).click();

            find(text("立即申购")).click();

            try{
                find(text("委托已提交"));
            }catch(NoSuchElementException e){}

            find(text("确认")).click();

            return this;
        }
    }

    public YjdxPage gotoYjdx() throws InterruptedException {

        By back=By.className("android.widget.ImageView");

        find(back).click();
        return new YjdxPage();
    }
}
