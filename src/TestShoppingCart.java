import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestShoppingCart {
	static WebDriver driver = new HtmlUnitDriver();
	
	//Add one item to an empty shopping cart.
	//After adding the item to the empty shopping cart, the user should be shown that there's one item in the shopping cart.
    @Test
    public void testAddItem(){  
    	driver.get("http://www.amazon.com/Head-First-Java-Kathy-Sierra/dp/0596009208/ref=sr_1_3?ie=UTF8&qid=1436058947&sr=8-3&keywords=java");
    	//driver.get("http://www.amazon.com/Head-First-Java-Kathy-Sierra/dp/0596009208/ref=sr_1_2?ie=UTF8&qid=1436040888&sr=8-2&keywords=java");
    	
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
    
    //Delete items from an empty shopping cart.
    //Since the shopping cart is empty, users should be shown that the cart is empty and they cannot delete any item from the cart.
    @Test
    public void testDeleteWithEmptyCart(){
    	driver.get("https://www.amazon.com/gp/cart/view.html/ref=nav_cart");
    	
    	try {

    		WebElement result = driver.findElement(By.id("sc-active-cart"));
    		String actual = result.findElement(By.tagName("h1")).getText();
    	    String expected = "Your Shopping Cart is empty.";
    	    assertEquals(expected, actual);
    	    assertTrue(actual.contains("empty"));

		} catch (NoSuchElementException e) {
			fail();
		}
    }
}
