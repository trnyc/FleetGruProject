package com.fleetGru.utilities;

import org.openqa.selenium.JavascriptExecutor;

public class BrowserUtils {

    /*
This method will accept int (in seconds) and execute Thread.sleep
for given duration
 */
    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }

    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */

    /**
     * Open a new tab and navigates to given url
     * ATTENTION: driver will be stayed on the current(previous) tab, not the new opening tab
     */
    public static void openNewTab(String url){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('"+url+"','_blank');");
    }

    /**
     * This method close the tab/tabs which have the given title
     * And switch to tab which have different title
     * @param pageTitle
     */
    public static void closeSpecificTab(String pageTitle){
        String newTab = "";
        for (String eachWindow : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(eachWindow);
            if (Driver.getDriver().getTitle().equals(pageTitle)){
                Driver.getDriver().close();
            }else{
                newTab = eachWindow;
            }
        }
        Driver.getDriver().switchTo().window(newTab);
    }


}
