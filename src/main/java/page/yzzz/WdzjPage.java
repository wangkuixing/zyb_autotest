package page.yzzz;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import page.BasePage;

public class WdzjPage extends BasePage {
    By back=By.className("android.widget.ImageView");

    public Boolean wdZj() throws InterruptedException {
        try{
            find(text("人民币"));
            find(text("余额"));

            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public YzzzPage gotoYzzz() throws InterruptedException {
        find(back).click();
        return new YzzzPage();
    }
}
