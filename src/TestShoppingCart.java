import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestShoppingCart {
	static WebDriver driver = new HtmlUnitDriver();

	//Add one item to an empty shopping cart.
	//After adding the item to the empty shopping cart, the user should be shown that there's one item in the shopping cart.
    @Test
    public void testAddItem(){
    	driver.get("http://www.amazon.com/Head-First-Java-Kathy-Sierra/dp/0596009208/ref=sr_1_2?ie=UTF8&qid=1436022385&sr=8-2&keywords=java");
    	
    	WebElement addButton = driver.findElement(By.id("add-to-cart-button"));
    	addButton.click();
    	
    	try {
    		WebElement result = driver.findElement(By.id("nav-cart-count"));
    		String actual = result.getText();
    		String expected = "1";
    		assertEquals(expected, actual);
		} catch (NoSuchElementException e) {
			fail();
		}
  
    }
    
    //Delete the only item in the shopping cart.
    //Since there's only item in the shopping cart, after deleting the item, the user should be shown that the shopping cart is 0.
    @Test
    public void testDeleteItem(){
    	driver.get("https://www.amazon.com/gp/cart/view.html/ref=lh_cart_vc_btn");

    	driver.findElement(By.name("submit.delete.C3UQM48TLC8H1Q")).submit();
    	
    	try {
    		WebElement result = driver.findElement(By.id("nav-cart-count"));
    		String actual = result.getText();
    		String expected = "0";
    		assertEquals(expected, actual);
		} catch (NoSuchElementException e) {
			fail();
		}
    	
    }
}
