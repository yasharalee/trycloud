package com.ty_cloud.step_defs;

public class TempFile {
    /*
    @When("the users click action-icon from random file or  folder and chooses {string}")
    public void the_users_click_action_icon_from_random_file_or_folder_and_chooses(String menu) {
        if (menu.equalsIgnoreCase("Remove from favorites") || menu.equalsIgnoreCase("Remove from favoriutes") && actions.size()>=1) {
            WaitFor.clickable(actions.get(0));
            for (int j = 1; j < 3; j++) {

                boolean done = false;

                for (int i = 0; i < 1; i++) {
                    if (actions.get(i).getText().equals("Actions")){
                        continue;
                    }
                    actions.get(i).click();
                    WebElement firstMenu = Driver.getDriver().findElement(By.xpath("" +
                            "(//*[@id=\"fileList\"]//ul//li//a)[3]"));
                    if (firstMenu.getText().equals(menu)) {
                        fileName = allElementsInLowerTable.get(i).getText();
                        firstMenu.click();
                        done = true;
                        break;
                    }
                    firstMenu.click();

                }
                if (done) {
                    break;
                }
            }
        } else {
            actions.get(0).click();
            subMenuByName(menu).click();
        }
    }

     */
}
