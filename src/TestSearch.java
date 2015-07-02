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
	  
	  @Test
	    public void testSearchItems(){
	      WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
	      search.sendKeys("Software");
	      search.submit();
	  }  
	  
	 
  
}
