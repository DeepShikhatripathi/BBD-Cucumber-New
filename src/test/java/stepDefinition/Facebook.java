package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Facebook {

	WebDriver browser;

	@Given("User is at facebook login page")
	public void user_is_at_facebook_login_page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\win10\\Documents\\chromedriver_win32_86\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		browser.get("http://www.facebook.com/");
	}

	@When("User enter valid user name")
	public void user_enter_valid_user_name() {
		browser.findElement(By.id("email")).sendKeys("tripathi.shikha29july@gmail.com");
	}

	@When("User enter invalid password")
	public void user_enter_invalid_password() {
		browser.findElement(By.id("pass")).sendKeys("shikha@29");
	}

	@When("User clicks on signin button")
	public void user_clicks_on_signin_button() {
		browser.findElement(By.name("login")).click();

	}

     @When("User enter valid user name {string}")
     public void user_enters_username(String userName) {
    	 
    	 browser.findElement(By.id("email")).sendKeys(userName);
        }

      @When("User enter invalid password {string}")
      public void user_enters_password(String password) {
    	  browser.findElement(By.id("pass")).sendKeys(password);
      }

	@Then("login is unsuccessfull with title {string} displayed on page")
       public void login_is_unsuccessfull_with_title(String text) {
  
    	String pageTitleText = browser.findElement(By.id("header_block")).getText();
    	System.out.println(text);
    	org.junit.Assert.assertEquals(text, pageTitleText);
     }


	@Then("login should not successful")
	public void login_should_not_successful() {
		org.junit.Assert.assertEquals("Facebook – log in or sign up", browser.getTitle());
	}

}
