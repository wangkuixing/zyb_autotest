package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static WebElement find(By locator) throws InterruptedException {
        Thread.sleep(3000);
        try {
            return Driver.getCurrentDriver().findElement(locator);
        }catch(Exception e){
            e.printStackTrace();
            //if (Driver.getCurrentDriver().findElement(By.xpath("//android.widget.TextView[contains(@text, '获取栏目列表信息失败')]")))
            Driver.getCurrentDriver().findElement(text("确定")).click();
            return Driver.getCurrentDriver().findElement(locator);
        }
    }

    public static By locate(String locator){
        if(locator.matches("/.*")){
            return By.xpath(locator);
        }else{
            return By.id(locator);
        }
    }
    public static By text(String content){
        return By.xpath("//*[@text='"+ content + "']");
    }

    public static WebElement content_desc(String desc){
        return Driver.getCurrentDriver().findElementByAccessibilityId(desc);
    }

    public Boolean isElementExist(By locator){
        try{
            Driver.getCurrentDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    //封装显式等待
    public static WebElement waituntil(By locator){
        WebDriverWait wait=new WebDriverWait(Driver.getCurrentDriver(),10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
