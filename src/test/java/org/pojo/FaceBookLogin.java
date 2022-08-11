package org.pojo;

import org.base.BaseUtilityClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookLogin extends BaseUtilityClass {
	
	public FaceBookLogin() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//input[@placeholder='Email address or phone number']")
	private WebElement emailField;
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passField;
	@FindBy(xpath = "//button[text()='Log In']")
	private WebElement loginField;
	
	
	public WebElement getEmailField() {
		return emailField;
	}
	public WebElement getPassField() {
		return passField;
	}
	public WebElement getLoginField() {
		return loginField;
	}
	

}
