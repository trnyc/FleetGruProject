package com.fleetGru.step_definitions;


import com.fleetGru.pages.HomePage;
import com.fleetGru.pages.LoginPage;
import com.fleetGru.utilities.BrowserUtils;
import com.fleetGru.utilities.ConfigurationReader;
import com.fleetGru.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

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

    @Then("The user should see {string} message if {string} or {string} is empty")
    public void theUserShouldSeeMessageIfOrIsEmpty(String expectedMessage, String userName, String pw) {

        if (pw.equals(null)) {
            String actualMessage = Driver.getDriver().findElement(By.id("prependedInput")).getAttribute("validationMessage");
            Assert.assertEquals(expectedMessage, actualMessage);

        } else if (userName.equals(null)) {
            String actualMessage = Driver.getDriver().findElement(By.id("prependedInput2")).getAttribute("validationMessage");
            Assert.assertEquals(expectedMessage, actualMessage);


        }


    }


    //prependedInput


	/*@Test
	public void test(){
		Driver.getDriver().get(ConfigurationReader.get("url"));
		String actualMessage= Driver.getDriver().findElement(By.id("prependedInput")).getAttribute("validationMessage");
		System.out.println(actualMessage);
	}
*/


}
