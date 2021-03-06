package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;
/**
 * Created by vanithakasala on 26/05/2016.
 */
public class Driver {
    public static AppiumDriver iOSdriver;
    public static WebDriver webDriver;

    public static void appiumDriver() {
       try {
                String workingDir = System.getProperty("user.dir");
                File appDir = new File(workingDir + "/app");
                File app = new File(appDir, "Albert.app");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(CapabilityType.VERSION, "9.3");
                capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("deviceName", "iPhone 6 Plus");
                capabilities.setCapability("platformVersion", "9.3");
                capabilities.setCapability("app", app.getAbsolutePath());
                iOSdriver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (Exception e) {
            System.out.println("Error on intializing Albert App");
        }
    }

    public static void firefoxDriver() {
        try {
            webDriver = new FirefoxDriver();
        } catch (Exception e) {
            System.out.println("Error on intializing firefox browser");
        }
    }
}

