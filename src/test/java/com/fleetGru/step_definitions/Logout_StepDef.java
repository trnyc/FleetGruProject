package com.fleetGru.step_definitions;

import com.fleetGru.pages.HomePage;
import com.fleetGru.pages.LoginPage;
import com.fleetGru.utilities.BrowserUtils;
import com.fleetGru.utilities.ConfigurationReader;
import com.fleetGru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Logout_StepDef {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("User is on the homepage")
    public void user_is_on_teh_homepage() {
        loginPage.goLoginPage();
        loginPage.loginAsUserType("Driver");
    }
    @When("user open profile menu")
    public void user_open_profile_menu() {
        HomePage.userInfo.click();
    }
    @When("user click on logout link")
    public void user_click_on_logout_link() {
        homePage.logoutButton.click();
    }
    @Then("user land on login page")
    public void user_land_on_login_page() {
        Assert.assertTrue(loginPage.loginHeader.isDisplayed());
    }


    @And("user click on step back button")
    public void userClickOnStepBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("user can not go to homepage")
    public void userCanNotGoToHomepage() {
        String actualTitle = Driver.getDriver().getTitle();
        String unexpectedTitle = "Dashboard";
        Assert.assertNotEquals(unexpectedTitle, actualTitle);
    }

    @When("user open two homepage tabs")
    public void userOpenTwoHomepageTabs() {
        BrowserUtils.openNewTab(ConfigurationReader.get("url"));
        BrowserUtils.openNewTab("");
    }

    @And("user close all tabs")
    public void userCloseAllTabs() {
        BrowserUtils.closeSpecificTab("Dashboard");
        BrowserUtils.closeSpecificTab("Dashboard");



    }

    @And("user reopen the url")
    public void userReopenTheUrl() {
        BrowserUtils.sleep(2);
        Driver.getDriver().get(ConfigurationReader.get("url"));
    }

    @Then("user can not land on homepage")
    public void userCanNotLandOnHomepage() {
        String unexpectedTitle = "Dashboard";
        String actualTitle = Driver.getDriver().getTitle();
        BrowserUtils.sleep(5);
        Assert.assertNotEquals(unexpectedTitle, actualTitle);
    }
}
