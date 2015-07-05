
import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestPlaceOrder {
	
	static WebDriver driver = new HtmlUnitDriver();
	
	//log in first
	@Before
	public void setup(){
		driver.get("https://www.amazon.com/ap/signin/190-9864099-5944649?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_signin");
		driver.findElement(By.id("ap_email")).sendKeys("2014shufehey@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("2014shufe");
		driver.findElement(By.id("signInSubmit-input")).submit();
	}
	
	// Given that I am in the shopping cart page of my account, ready to pay, and there is one items in the shopping cart
	// And the shipping address and payment method have already been set
	// When I click "Proceed to checkout" --> "Ship to this address" --> "Continue" --> "Continue"
	// Then I should see the button "Place your order"
	   @Test
	   public void successPayment(){
			driver.get("https://www.amazon.com/gp/cart/view.html/ref=nav_cart");
			driver.findElement(By.name("proceedToCheckout")).click();  //"Proceed to checkout"
			WebElement div=driver.findElement(By.id("address-book-entry-0"));   //"Ship to this address"
			div.findElement(By.cssSelector("a.a-declarative.a-button-text ")).click();
			driver.findElement(By.className("a-button-text")).click();  //"Continue"
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.findElement(By.id("continue-top")).click();;  //"Continue"
		    try{
		    	String str=driver.findElement(By.name("placeYourOrder1")).getAttribute("value");
				assertEquals(str,"Place your order");
		    }catch(NoSuchElementException e){
		    	fail();
		    }	
	  }
	   
	 //Given that I am in the shopping cart page of my account, ready to pay, and there is one items in the shopping cart
	 //And assume the shipping address and payment method haven't been set
	 //When I click "Proceed to checkout"-->"Ship to this address"(without shipping information)
	 //Then I shouldn't see the button "Continue"
		   @Test
		   public void failPayment(){
			   driver.get("https://www.amazon.com/gp/cart/view.html/ref=nav_cart");
			   driver.findElement(By.name("proceedToCheckout")).click();  //"Proceed to checkout"
			   driver.findElement(By.name("shipToThisAddress")).click();;   //"Ship to this address"
			   try{
				   WebElement continurBt=driver.findElement(By.className("a-button-text"));  //find "Continue" button
				   assertTrue(continurBt.isDisplayed() && continurBt.getAttribute("value")=="Continue");
			   }catch(NoSuchElementException e){
				   fail();
			   }  
		   }  
	
	 
}
