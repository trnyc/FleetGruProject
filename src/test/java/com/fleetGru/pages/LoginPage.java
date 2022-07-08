package com.fleetGru.pages;


import com.fleetGru.utilities.ConfigurationReader;
import com.fleetGru.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	//---locators----------------

	@FindBy(id = "prependedInput")
	public WebElement usernameField;

	@FindBy(id = "prependedInput2")
	public WebElement passwordField;

	@FindBy(id = "_submit")
	private WebElement loginBtn;



	//---methods-----------------

	public void goLoginPage(){
		Driver.getDriver().get(ConfigurationReader.get("url"));
	}


	public void loginAsUserType(String userType){

		String password = "";
		String username = "";

		if (userType.equals("Driver")) {
			username = ConfigurationReader.get("driver_username");
			password = ConfigurationReader.get("driver_password");
		}
		else if (userType.equals("Sales Manager")) {
			username = ConfigurationReader.get("sales_manager_username");
			password = ConfigurationReader.get("sales_manager_password");
		}
		else if (userType.equals("Store Manager")) {
			username = ConfigurationReader.get("store_manager_username");
			password = ConfigurationReader.get("store_manager_password");
		}

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}


	public void loginWithCredentials(String username, String password){
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}

	public void inputCredentials(String username, String password){
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);

	}


	public String getPageTitle(){
		return Driver.getDriver().getTitle();
	}

	@FindBy(linkText = "Forgot your password?")
	public WebElement forgotPwButton;

	@FindBy(id = "remember_me")
	public WebElement rememberMeCheckBox;

	@FindBy(xpath = "//span[.='Remember me on this computer']")
	public WebElement rememberMeLink;

	@FindBy(xpath = "//h2[.='Login']")
	public WebElement loginHeader;



}
