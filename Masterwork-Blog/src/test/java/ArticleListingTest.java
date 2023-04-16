import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ArticleListingTest {
  public static void main(String[] args) {
    // Set the system property for the Chrome driver
    System.setProperty("webdriver.chrome.driver", "/Users/sudardavid/Downloads/chromedriver_mac64/chromedriver");

    // Create an instance of ChromeDriver
    WebDriver driver = new ChromeDriver();

    // Navigate to the web page
    driver.get("http://test-automation-blog.greenfox.academy");

    // Find the article elements
    List<WebElement> articleElements = driver.findElements(By.cssSelector(".blog-entry-inner.clr"));

    // Print the article titles
    System.out.println("Total Articles: " + articleElements.size());
    for (WebElement articleElement : articleElements) {
      System.out.println("Article Title: " + articleElement.getText());
    }

    // Close the browser window
    driver.quit();
  }
}

