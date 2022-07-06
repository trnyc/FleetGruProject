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
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

public class Login_StepDef {

    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();

    //--------------------------------------------------------

    @When("The user logs in as a {string}")
    public void the_user_logs_in_as_a(String userType) {
        loginPage.loginAsUserType(userType);
        loginPage.waitUntilLoaderScreenDisappear();
    }

    @Then("The user is on the {string} page")
    public void the_user_is_on_the_page(String expectedTitle) {
        String actualTitle = homePage.getSubtitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    //--------------------------------------------------------

    @When("The user tries to login with {string} and {string}")
    public void the_user_tries_to_login_with_and(String username, String password) {
        loginPage.loginWithCredentials(username, password);
        BrowserUtils.sleep(2);
    }

    @Then("The user can not login and page title is {string}")
    public void the_user_can_not_login_and_page_title_is(String expectedPageTitle) {
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(expectedPageTitle, actualTitle);
    }

    //--------------------------------------------------------

    @When("The user logs in with following credentials \\(list)")
    public void the_user_logs_in_with_following_credentials(List<String> credentialsList) {
        String username = credentialsList.get(0);
        String password = credentialsList.get(1);
        loginPage.loginWithCredentials(username, password);

        loginPage.waitUntilLoaderScreenDisappear();
    }

    //--------------------------------------------------------

    @When("The user logs in with following credentials \\(map)")
    public void the_user_logs_in_with_following_credentials(Map<String, String> credentialsMap) {
        String username = credentialsMap.get("username");
        String password = credentialsMap.get("password");
        loginPage.loginWithCredentials(username, password);

        loginPage.waitUntilLoaderScreenDisappear();
    }


    @Given("The user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.goLoginPage();
    }


    @Then("The user should see {string} message if password is empty")
    public void theUserShouldSeeMessageIfPasswordIsEmpty(String expectedMessage) {
        String actualMessage = Driver.getDriver().findElement(By.id("prependedInput2")).getAttribute("validationMessage");
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("And The user should see {string} message if username is empty")
    public void andTheUserShouldSeeMessageIfUsernameIsEmpty(String expectedMessage) {
        String actualMessage = Driver.getDriver().findElement(By.id("prependedInput")).getAttribute("validationMessage");
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("The user clicks Forgot your password? link")
    public void theUserClicksForgotYourPasswordLink() {
        loginPage.forgotPwButton.click();
    }

    @Then("The user should land on {string} page")
    public void theUserShouldLandOnForgotPasswordPage(String expectedTitle) {
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }

    @When("User can see Remember Me Link")
    public void userCanSeeRememberMeLink() {
        loginPage.rememberMeLink.isDisplayed();
    }

    @Then("User able to click on Remember Me link")
    public void userAbleToClickOnRememberMeLink() {
        loginPage.rememberMeLink.click();
        Assert.assertTrue(loginPage.rememberMeCheckBox.isSelected());
    }

    @When("User can pass {string} as a password")
    public void userCanPassAnythingAsAPassword(String pw) {
        loginPage.passwordField.sendKeys(pw);
    }

    @Then("The password should be seen in bullet sign")
    public void thePasswordShouldBeSeenInBulletSign() {
        Assert.assertEquals("password",loginPage.passwordField.getAttribute("type"));
    }


    @Then("User should login with Enter key when cursor on the user input box")
    public void userShouldLoginWithEnterKeyWhenCursorOnTheUserInputBox() {
        loginPage.usernameField.sendKeys(Keys.ENTER);
        BrowserUtils.sleep(2);
        Assert.assertTrue(homePage.pageSubtitle.isDisplayed());
    }


    @And("User should login with Enter key when cursor on the password input box")
    public void userShouldLoginWithEnterKeyWhenCursorOnThePasswordInputBox() {
        loginPage.passwordField.sendKeys(Keys.ENTER);
        BrowserUtils.sleep(5);
        Assert.assertTrue(homePage.pageSubtitle.isDisplayed());
    }

    @When("The user inputs {string} and {string}")
    public void theUserInputsAnd(String username, String pw) {
        loginPage.inputCredentials(username,pw);
    }

	/*
	@Test
	public void test(){
		Driver.getDriver().get(ConfigurationReader.get("url"));
        loginPage.usernameField.sendKeys("user1");
        loginPage.passwordField.sendKeys("UserUser123"+Keys.ENTER);

        Assert.assertEquals("user",Driver.getDriver().findElement(By.id("user-menu")).getText());


	}*/


    @Then("User should see his {string} in profile menu")
    public void userShouldSeeHisInProfileMenu(String expectedUserName) {
        homePage.waitUntilLoaderScreenDisappear();
        String actualUserName= homePage.userInfoGet();
        Assert.assertEquals("User name matching error!",expectedUserName,actualUserName);

    }
}
