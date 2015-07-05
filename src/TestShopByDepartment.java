import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class TestShopByDepartment {
	
	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for amazon for each test
		@Before
		public void setUp() throws Exception {
			driver.get("https://www.amazon.com");
		}

	//Given that I am in the main page
    //When I select “Books & Audible” department from Shop by Department, and click “Magazines” under Books’ category
    //Then the tilte of the page becomes "Amazon.com: Magazine Subscriptions"
		@Test
		public void shopByDepartment(){
			driver.findElement(By.id("nav-link-shopall")).click();
			driver.findElement(By.partialLinkText("Magazines")).click();
			String val=driver.getTitle();
			assertEquals(val,"Amazon.com: Magazine Subscriptions");
		}

}
