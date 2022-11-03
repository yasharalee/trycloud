package com.ty_cloud.utilities;

import org.openqa.selenium.By;

public class Utils {

    private Utils(){}

    public static void Logout(){
        Driver.getDriver().findElement(By.xpath("//div[@class='avatardiv avatardiv-shown']//img")).click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='Log out']")).click();
    }

}
