import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestLogIn {
	
	//Given that I'm on the page for signing in,
	//when I enter invalid email and password,
	//then I see warning message telling me that the email or the password is invalid.
	@Test
	public void testLogInvalid(){
		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_signin");

		String email = "1234";
		String password = "1234";
		
		WebElement em = driver.findElement(By.id("ap_email"));
		em.sendKeys(email);
		em.submit();
		WebElement pa = driver.findElement(By.id("ap_password"));
		pa.sendKeys(password);
		pa.submit();
		
		try {
			WebElement result = driver.findElement(By.id("message_warning")).findElement(By.tagName("h6"));
			String actual = result.getText();
			String expected = "Important Message!";
			assertEquals(expected, actual);
			driver.quit();
		} catch (NoSuchElementException e) {
			fail();
		}
		
	}
	
	//Given that I'm on the page for signing in,
	//when I enter valid email and password,
	//then I see my main page on Amazon.
	@Test
	public void testLogValid(){
		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_signin");

		String email = "2014shufehey@gmail.com";
		String password = "2014shufe";
		
		WebElement em = driver.findElement(By.id("ap_email"));
		em.sendKeys(email);
		em.submit();
		WebElement pa = driver.findElement(By.id("ap_password"));
		pa.sendKeys(password);
		pa.submit();
		
		try {
			WebElement result = driver.findElement(By.id("nav-your-amazon"));
			String actual = result.getText();
			String expected = "2014shu...'s Amazon.com";
			assertEquals(expected, actual);
			driver.quit();
		} catch (NoSuchElementException e) {
			fail();
		}
	}
  
}
