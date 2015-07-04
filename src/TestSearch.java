import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class TestSearch {
	static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp() throws Exception {
	  driver.get("http://www.amazon.com");
	}
	
    //Test the searching function of the website.
    //Enter the name of an existing product in the searching bar in the home page.
    //Since the item is existed, there should be the name of the item in the list of the returned result.
	@Test
	public void testSearchExistingItems(){
	  WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
	  search.sendKeys("Furious 7");
	  search.submit();
	  
	  WebElement result = driver.findElement(By.id("result_0"));
	  WebElement productName = result.findElement(By.tagName("h2"));
	  String actual = productName.getText();
	  String expected = "Furious 7";
	  assertEquals(expected, actual);
	}  
	
	//Test the searching function of the website.
	//Enter the name of a product which doesn't exist in the searching bar in the home page.
	//Since the item is not existed, there should be a message returned telling the user that there's no such product.
	@Test
	public void testSearhItemsNotExisted(){
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("12446446");
		search.submit();
		  
		WebElement result = driver.findElement(By.id("noResultsTitle"));
		String actual = result.getText();
		String expected = "Your search " + "\"12446446\"" + " did not match any products.";
		assertEquals(expected, actual);
	}

}
