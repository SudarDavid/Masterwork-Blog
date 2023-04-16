import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PaginationTest {
  public static void main(String[] args) {
    // Set the path to the ChromeDriver executable
    System.setProperty("webdriver.chrome.driver", "/Users/sudardavid/Downloads/chromedriver_mac64/chromedriver");

    // Create an instance of ChromeDriver
    WebDriver driver = new ChromeDriver();

    // Navigate to the first page of the data list
    driver.get("http://test-automation-blog.greenfox.academy");

    // Find and list the article titles on the first page
    List<WebElement> articleElementsPage1 = driver.findElements(By.cssSelector(".blog-entry-inner.clr"));
    System.out.println("Total Articles on Page 1: " + articleElementsPage1.size());
    for (WebElement articleElement : articleElementsPage1) {
      System.out.println("Article Title: " + articleElement.getText());
    }

    // Find and click the page jumper link
    WebElement pageJumperLink = driver.findElement(By.xpath("//div[@class='page-jump clr']//a[1]"));
    pageJumperLink.click();

    // Wait for the second page to load
    // Add necessary wait commands here if needed

    // Find and list the article titles on the second page
    List<WebElement> articleElementsPage2 = driver.findElements(By.cssSelector(".blog-entry-inner.clr"));
    System.out.println("Total Articles on Page 2: " + articleElementsPage2.size());
    for (WebElement articleElement : articleElementsPage2) {
      System.out.println("Article Title: " + articleElement.getText());
    }

    // Close the browser window
    driver.quit();
  }
}




