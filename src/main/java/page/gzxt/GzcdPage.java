package page.gzxt;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.BasePage;

import java.util.ArrayList;

public class GzcdPage extends BasePage {

    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By none=By.xpath("//android.webkit.WebView/android.view.View[1]");
    String cwsj="查无数据";
    By queding=text("确定");
    By back=By.className("android.widget.ImageView");

    String message;

    public GzcdPage gzCd() {

        if (find(none).getText().contains(cwsj)){
            message=cwsj;
        }
        else {
            ArrayList<WebElement> array=new ArrayList<>();
            for (WebElement e: Driver.getCurrentDriver().findElements(By.xpath("//*[@text='点击撤单']"))){
                array.add(e);
            }
            array.get(0).click();

            find(queding).click();
            message=find(msg).getText();
            find(queding).click();
        }
        return this;
    }

    public String getMessage(){
        return message;
    }

    public GzPage gotoGz(){

        waituntil(back);
        find(back).click();

        return new GzPage();
    }
}
