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
	
        //Given that I'm on the page for searching items,
        //when I search an existed item,
        //then I see the list of results containing the item that I search.
	@Test
	public void testSearchExistingItems(){
		
	     //search the existing item "Furious7"
	     WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
	     search.sendKeys("Furious 7");
	     search.submit();
	  
	      //users should see a returned list of the searching result and the first one should be the item we search
	      WebElement result = driver.findElement(By.id("result_0"));
	      WebElement productName = result.findElement(By.tagName("h2"));
	      String actual = productName.getText();
	      String expected = "Furious 7";
	      assertEquals(expected, actual);
	}  
	
	//Given that I'm on the page for searching items,
	//when I search an item which doesn't exist,
	//then I see a message telling me that there's no matching products.
	@Test
	public void testSearhItemsNotExisted(){
		
		//search an item "12446446", which doesn't exist
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("12446446");
		search.submit();
		  
		//users should see a message saying that there's no matching products
		WebElement result = driver.findElement(By.id("noResultsTitle"));
		String actual = result.getText();
		String expected = "Your search " + "\"12446446\"" + " did not match any products.";
		assertEquals(expected, actual);
	}

}
