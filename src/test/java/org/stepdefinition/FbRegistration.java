package org.stepdefinition;

import org.Pojo.BaseClass;
import org.Pojo.SignupPojo;
import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FbRegistration extends BaseClass {
	

@Given("To launch the browser and maximise the window")
public void to_launch_the_browser_and_maximise_the_window() {
	lanchBrowser();
	windowmaximize();
	
}

@When("To launch url of fb application")
public void to_launch_url_of_fb_application() {
	lanuchurl("https://www.myntra.com/?utm_source=dms_google&utm_medium=searchbrand_cpc&utm_campaign=dms_google_searchbrand_cpc_Search_Brand_Myntra_Brand_India_BM_TROAS_SOK&gclid=EAIaIQobChMIjczAkMy6_QIVCR4rCh2IoASqEAAYASAAEgLXdvD_BwE");
    
}

@When("To click the create new account button")
public void to_click_the_create_new_account_button() {
	driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
	
	
	
    
}

@When("To pass first in first name text box")
public void to_pass_first_in_first_name_text_box(io.cucumber.datatable.DataTable dataTable) {
	driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span")).click();
   
}

@When("To pass in second name in second  name textbox")
public void to_pass_in_second_name_in_second_name_textbox() {
    
}

@When("To pass mobileno or email in email text box")
public void to_pass_mobileno_or_email_in_email_text_box(io.cucumber.datatable.DataTable dataTable) {
	driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("90654335677");
    
}

@When("To create new password using new password text box")
public void to_create_new_password_using_new_password_text_box() {
    driver.findElement(By.xpath("//*[@id=\"continue\"]")).click()
}

@Then("To close the chrome browser")
public void to_close_the_chrome_browser() {
	CloseEntireBrowser();
}



}
