package page;


import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends BasePage{
    By profile=By.id("user_profile_icon");
    By hq=text("行情");
    By trade=text("交易");

    public static MainPage start(){
        Driver.start();
        return new MainPage();
    }

    public MainPage gotoMyself(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Driver.getCurrentDriver().findElement(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='雪球']")).click();
        return new MainPage();
    }

    public HqPage gotoHq() throws InterruptedException {
        find(hq).click();
        return new HqPage();

    }

    public TradePage gotoTrade() throws InterruptedException {
        find(trade).click();
        return new TradePage();
    }

    public SearchPage gotoSearch(){
        Driver.getCurrentDriver().findElement(By.id("home_search")).click();
        return new SearchPage();
    }

    public ZixuanPage gotoZixuan() throws InterruptedException {
        find(text("自选")).click();
        return new ZixuanPage();
    }
}

