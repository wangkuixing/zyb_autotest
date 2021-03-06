package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ChaxunPage extends BasePage{
    public Boolean chaxunTest() throws InterruptedException {
        try{
           find(text("人民币"));
            find(text("可用"));
           return true;
        }
        catch (NoSuchElementException e){
            return false;
        }

    }

    public TradePage gotoTrade() throws InterruptedException {
        By back=By.className("android.widget.ImageView");
        find(back).click();
        return new TradePage();
    }
}
