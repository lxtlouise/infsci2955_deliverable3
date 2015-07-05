import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;


public class TestChangeOrderNum {
	
	static WebDriver driver=new FirefoxDriver();
	
	//log in first and go to the shopping cart page
		@Before
		public void setup(){
			driver.get("https://www.amazon.com/ap/signin/190-9864099-5944649?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_signin");
			driver.findElement(By.id("ap_email")).sendKeys("2014shufehey@gmail.com");
			driver.findElement(By.id("ap_password")).sendKeys("2014shufe");
			driver.findElement(By.id("signInSubmit-input")).submit();
			driver.get("https://www.amazon.com/gp/cart/view.html/ref=gno_cart");
		}
	
	//Given that I've logged in, in the shopping cart page
	//And there is two item in the shopping cart
	//When I change one of the order number from 1 to 6
	//Then the number in of items in the shopping cart is 6
		@Test
		public void changeToValidNum(){
			driver.findElement(By.id("a-autoid-3-announce")).click();
			driver.findElement(By.id("dropdown1_5")).click();
			//driver.findElement(By.cssSelector("#nav-link-yourAccount > span.nav-line-1")).click();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("nav-cart-count")).click();
			String num=driver.findElement(By.id("nav-cart-count")).getText();
			assertEquals("6",num);	
		}
		
	//Given that I've logged in, in the shopping cart page
	//And there are two item in the shopping cart
	//When I change one of the order number from 6 to 100
	//Then the number of items in the shopping cart should become 100
		@Test
		public void changeToInvalidNum(){
			driver.findElement(By.id("a-autoid-3-announce")).click();
			driver.findElement(By.id("dropdown1_9")).click();
			driver.findElement(By.name("quantityBox")).sendKeys("100");
			driver.findElement(By.id("a-autoid-4-announce")).click();
			driver.findElement(By.id("nav-cart-count")).click();
			String num=driver.findElement(By.id("nav-cart-count")).getText();
			assertEquals("100",num);
		}
		
	
		
}
