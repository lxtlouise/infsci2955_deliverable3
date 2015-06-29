import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
public class TestSearch {
  public static void main(String[] args){
	  WebDriver driver = new FirefoxDriver();
	  driver.get("www.amazon.com");
	  
	  WebElement search = driver.findElement(By.id("twotabssearchtextbox"));
	  search.sendKeys("Software");
	  search.submit();
	  
	  
  }
}
