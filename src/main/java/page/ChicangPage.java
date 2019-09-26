package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ChicangPage extends BasePage{

    public Boolean chicangTest() throws InterruptedException {

        try {
            find(text("总资产"));
            find(text("证券市值"));
            find(text("成本价"));
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public TradePage gotoTrade() throws InterruptedException {

        By back=By.className("android.widget.ImageView");

        find(back).click();
        return new TradePage();

    }
}
