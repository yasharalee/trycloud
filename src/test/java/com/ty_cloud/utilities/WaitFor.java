package com.ty_cloud.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {

    private WaitFor() {
    }

    private static final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    public static void visibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void invisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void clickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void alertDisplayed() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void Seconds(int seconds){
        try {
            Thread.sleep(seconds* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void milliSeconds(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
