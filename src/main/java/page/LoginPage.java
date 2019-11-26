package page;

import driver.Driver;
import org.openqa.selenium.By;


public class LoginPage extends BasePage{
    By username=By.id("edit_account");
    By password=By.id("edit_password");
    By loginbtn=By.id("login");
    String message;
//    public LoginPage passwordFail(String username, String password){
//        find(shouji).click();
//        find(youxiang).click();
//        find(this.username).sendKeys(username);
//        find(this.password).sendKeys(password);
//        find(loginbtn).click();
//        message=find(msg).getText();
//        find(By.id("md_buttonDefaultPositive")).click();
//
//        return this;
//    }

    public BuyPage passwordSuccess(String username, String password) throws InterruptedException {
        find(this.username).sendKeys(username);
        find(this.password).sendKeys(password);
        find(loginbtn).click();
        return new BuyPage();
    }

    public String getMessage(){
        return message;
    }
}
