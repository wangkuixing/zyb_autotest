package page.ggt;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.BasePage;

import java.util.ArrayList;

public class GgchedanPage extends BasePage {

    By msg=By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    By queding=text("确定");
    By back=By.className("android.widget.ImageView");

    String message;

    public GgchedanPage chedan(){

        //todo: 改造新增无委托情况的判断
        ArrayList<WebElement> array=new ArrayList<>();
        for (WebElement e: Driver.getCurrentDriver().findElements(By.xpath("//*[@text='点击撤单']"))){
            array.add(e);
        }
        array.get(0).click();

        find(queding).click();
        message=find(msg).getText();
        find(queding).click();

        return this;
    }

    public String getMessage(){
        return message;
    }

    public GgtPage gotoGgt(){

        find(back).click();

        return new GgtPage();
    }
}
