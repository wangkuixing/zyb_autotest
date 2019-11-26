package page;

import driver.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import page.cnjj.CnjjPage;
import page.ggt.BuyggtPage;
import page.ggt.GgtPage;
import page.gznhg.NhgPage;
import page.gzxt.GzPage;
import page.hbjj.HbjjPage;
import page.kfsjj.KfsjjPage;
import page.yzzz.YzzzPage;

import java.time.Duration;

public class TradePage extends BasePage {

    public  LoginPage gotoLogin() throws InterruptedException {
        By mr=text("买入");
        find(mr).click();
        return new LoginPage();
    }

    public  BuyPage gotoBuy() throws InterruptedException {
        find(text("买入")).click();
        return new BuyPage();
    }

    public  SalePage gotoSale() throws InterruptedException {
        find(text("卖出")).click();
        return new SalePage();
    }

    public ChedanPage gotoChedan() throws InterruptedException {
        find(text("撤单")).click();
        return new ChedanPage();
    }

    public ChaxunPage gotoChaxun() throws InterruptedException {
        find(text("查询资金")).click();
        return new ChaxunPage();
    }

    public ChicangPage gotoChicang() throws InterruptedException {
        find(text("我的持仓")).click();
        return new ChicangPage();
    }

    public MorePage gotoMore() throws InterruptedException {
        find(text("更多")).click();
        return new MorePage();
    }

    public YjdxPage gotoYjdx() throws InterruptedException {
        find(text("一键打新")).click();
        return new YjdxPage();
    }

    public NhgPage gotoNhg() throws InterruptedException {
        find(text("国债逆回购")).click();
        return new NhgPage();
    }

    public YzzzPage gotoYzzz() throws InterruptedException {
        find(By.xpath("//android.view.View[@text='银证转账']")).click();
        return new YzzzPage();
    }

    public GgtPage gotoGgt() throws InterruptedException {
        swipeControl();
        find(By.xpath("//android.view.View[@text='港股通交易']")).click();
        return new GgtPage();
    }

    public GzPage gotoGz() throws InterruptedException {
        swipeControl();
        find(By.xpath("//android.view.View[@text='股转业务']")).click();
        return new GzPage();
    }

    public KfsjjPage gotoKfsjj() throws InterruptedException {
        swipeControl();
        find(By.xpath("//android.view.View[@text='开放式基金']")).click();
        return new KfsjjPage();
    }

    public HbjjPage gotoHbjj() throws InterruptedException {
        swipeControl();
        find(By.xpath("//android.view.View[@text='实时货币基金']")).click();
        return new HbjjPage();
    }

    public CnjjPage gotoCnjj() throws InterruptedException {
        swipeControl();
        find(By.xpath("//android.view.View[@text='场内基金']")).click();
        return new CnjjPage();
    }

    public TradePage logOut(String name) throws InterruptedException {
        find(text(name)).click();
        find(text("确定")).click();
        return new TradePage();
    }

    //上滑页面从3/4位置滑动到1/4
    public TradePage swipeControl(){
        int width=Driver.getCurrentDriver().manage().window().getSize().width;
        int height=Driver.getCurrentDriver().manage().window().getSize().height;
        int y1=height*3/4;
        int y2=height*1/4;
        PointOption po1=new PointOption();
        po1.withCoordinates(width/2,y1);
        PointOption po2=new PointOption();
        po2.withCoordinates(width/2,y2);

        Duration duration=Duration.ofNanos(2000);
        WaitOptions wait=new WaitOptions();
        wait.withDuration(duration);

        TouchAction taction=new TouchAction(Driver.getCurrentDriver());
        taction.press(po1).waitAction(wait).moveTo(po2).release().perform();
        return new TradePage();

    }
}
