package com.ty_cloud.utilities;

import com.ty_cloud.pages.BasePage;
import com.ty_cloud.pages.FilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    private Utils() {
    }

    private static final Map<String, Integer> priority = new HashMap<>(Map.of(
            "B", 1,
            "KB", 2,
            "MB", 3,
            "GB", 4,
            "TB", 5
    ));

    public static int getPriority(String unit) {
        return priority.get(unit);
    }


    public static void Logout() {

        WebElement avatar = new BasePage().rightSideModules("Avatar");
        WaitFor.clickable(avatar);
        avatar.click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='Log out']")).click();
    }

    public String formatPath(String path) {
        return path.replace("\\", "/");
    }

    public static List<String> giveMeElementTexes(List<WebElement> list) {
        return list.stream().map(m -> m.getText().trim()).collect(Collectors.toList());
    }

    public static List<WebElement> giveMeCheckboxes(List<WebElement> list) {
        return list.stream().filter(m -> {
            return m.getAttribute("type").equals("checkbox");
        }).collect(Collectors.toList());
    }

    public static Integer giveMeNumbersOnly(String str) {
        String num = "";
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (Character.isDigit(letter)) {
                num += letter;
            }
        }
        return Integer.parseInt(num);
    }


    public static String usageByte(String str) {
        String s = str.substring(0, str.indexOf("u")).trim();
        String dum = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) && s.charAt(i) != ' ') {
                dum += s.charAt(i);
            }
        }
        return dum.trim();
    }

    public static String getTitle() {
        return Driver.getDriver().getTitle();
    }


}
