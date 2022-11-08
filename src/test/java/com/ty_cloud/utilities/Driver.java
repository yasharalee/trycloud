package com.ty_cloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){}

    //private static WebDriver driver;

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver(){

        if (driverPool.get() == null){

            String browser = ConfigReader.getProperty("browser");

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    break;
                default:
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            }
        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
