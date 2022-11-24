package com.ty_cloud.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class Common {


    public  WebElement findElement(String xpath){
        return  Driver.getDriver().findElement(By.xpath(xpath));
    }



        public Common(){
            PageFactory.initElements(Driver.getDriver(), this);
        }
        Actions act = new Actions(Driver.getDriver());

        public static String fileNameRemove;
        public static String fileNameAdd;

        @FindBy(xpath = "(//tbody[@id='fileList'])[1]//span[@class='innernametext']")
        public List<WebElement> allElementsInLowerTable;

        @FindBy(xpath = "//ul[@id='appmenu']//li//a")
        public List<WebElement> moduleElements;


        public void hoverOver(){
            act.moveToElement(moduleElements.get(0)).build().perform();
        }

        @FindBy(xpath = "(//tbody[@id='fileList'])[1]//a[@class='action action-menu permanent']")
        public List<WebElement> actions;


        @FindBy(xpath = "//span[@class='icon icon-add']")
        public WebElement addBtn;

        @FindBy(xpath = "//*[@id='uploadprogressbar']")
        public WebElement progressBar;

        @FindBy(xpath = "//input[@id='file_upload_start']")
        public WebElement inputFile;

        public WebElement subMenuByName(String menu){
            return Driver.getDriver().findElement(By.xpath("//div[@class='fileActionsMenu popovermenu bubble open menu']//span[.='"+menu+"']/.."));
        }

        public WebElement leftSideBarMenu(String menuName) {
            return Driver.getDriver().findElement(By.xpath("//div[@id='app-navigation']//a[.='" + menuName + "']"));
        }

        public WebElement rightSideModules(String menuName){
            Map<String, Integer> menus = new HashMap<>(Map.of(
                    "search",1,"notification",2,"contacts",3,"avatar",4
            ));

            return    Driver.getDriver().findElement(By.xpath("" +
                    "(//div[@class='header-right']/div)["+menus.get(menuName.toLowerCase())+"]"));

        }


        @FindBy(xpath = "//div[@id='header-menu-unified-search']//input")
        public WebElement searchInputOfContacts;

        public  List<WebElement> findElements(String xpath){
            List<WebElement> list = Driver.getDriver().findElements(By.xpath(xpath));
            return list;
        }

        public List < WebElement> searchResults(){
            List < WebElement>  list= new ArrayList<>();

            list.addAll(findElements("//span[@class='unified-search__result-content']//h3"));
            list.addAll(findElements("//h4[@class='unified-search__result-line-two']"));

            return list;
        }


        public int randomNumUpTo(int zeroTo) {
            Random random = new Random();
            return random.nextInt(zeroTo);
        }

        public WebElement getModuleByVisibleText(String text){
            hoverOver();
            WebElement menu = null;
            for (WebElement each : moduleElements) {
                if (each.getText().trim().equals(text)){
                    menu = each;
                }
            }
            return menu;
        }

    }




