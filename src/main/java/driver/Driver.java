package driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static AndroidDriver<WebElement> driver;
    public static void start(){
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();

        GlobalConfig config= GlobalConfig.load("/data/globalConfig.yaml");
        config.appium.capabilities.keySet().forEach(key->{
            Object value=config.appium.capabilities.get(key);
            desiredCapabilities.setCapability(key, value);
        });

        URL remoteurl=null;
        try {
            remoteurl=new URL(config.appium.url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver<>(remoteurl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(config.appium.wait, TimeUnit.SECONDS);
    }

    public static void stop(){
        driver.quit();
    }

    public static AndroidDriver<WebElement> getCurrentDriver(){
        return driver;
    }
}
