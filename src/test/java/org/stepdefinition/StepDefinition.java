package org.stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.base.BaseUtilityClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pojo.FaceBookLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition extends BaseUtilityClass {
	
	@Given("user enter in to facebook login page")
	public void user_enter_in_to_facebook_login_page() {
	 launchUrl("https://www.facebook.com/");
	}

	@When("User enter {string} and {string}")
	public void user_enter_and(String string, String string2) {
		FaceBookLogin f= new FaceBookLogin();
		fillValue(f.getEmailField(), string);
		fillValue(f.getPassField(), string2);
	   
	}

	@When("User click the login button")
	public void user_click_the_login_button() throws InterruptedException {
		
		FaceBookLogin f= new FaceBookLogin();
		
		clickElement(f.getLoginField());
		Thread.sleep(4000);
		
	   	}

	@Then("User should be in invalid credential page")
	public void user_should_be_in_invalid_credential_page() throws IOException {
		int count=1;
		screenshot("C:\\Users\\siddh\\eclipse-workspace\\MavenCucumber\\ScreenShot\\screenshot"+count+++".png");
		
		
		System.out.println("user is in invalid page");
	    
	}

	@When("user enter the invalid username and invalid password")
	public void user_enter_the_invalid_username_and_invalid_password(io.cucumber.datatable.DataTable dataTable) {
	   List<String> asList = dataTable.asList();
	   FaceBookLogin f=new FaceBookLogin();
	   fillValue(f.getEmailField(), asList.get(0));
	   fillValue(f.getPassField(), asList.get(1));
	}

	@When("user click the login button")
	public void user_click_the_login_button1() throws InterruptedException {
		 FaceBookLogin f=new FaceBookLogin();
		 clickElement(f.getLoginField());
		 Thread.sleep(3000);
	}

	@Then("user should be in inavlid credential page")
	public void user_should_be_in_inavlid_credential_page() throws IOException {
		
		
		System.out.println("user is in invalid credential page");
	    
	}

	@When("user enter the valid username and invalid password")
	public void user_enter_the_valid_username_and_invalid_password(io.cucumber.datatable.DataTable dataTable) {
	   
		List<String> asList = dataTable.asList();
		
		
		FaceBookLogin f=new FaceBookLogin();
		
		fillValue(f.getEmailField(), asList.get(0));
		fillValue(f.getPassField(),asList.get(1));
	}

	@When("user enter the valid username and valid password")
	public void user_enter_the_valid_username_and_valid_password(io.cucumber.datatable.DataTable dataTable) {

		List<String> asList = dataTable.asList();
		
		
		FaceBookLogin f=new FaceBookLogin();
		
		fillValue(f.getEmailField(), asList.get(0));
		fillValue(f.getPassField(),asList.get(2));  
	}

	@Then("user should not be in inavlid credential page")
	public void user_should_not_be_in_inavlid_credential_page() {
	    System.out.println("user is in valid page");
	}






}
