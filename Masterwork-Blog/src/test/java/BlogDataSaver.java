import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BlogDataSaver {
  public static void main(String[] args) {
    // Set the path to the chromedriver executable
    System.setProperty("webdriver.chrome.driver", "/Users/sudardavid/Downloads/chromedriver_mac64/chromedriver");

    // Create a new instance of ChromeDriver
    WebDriver driver = new ChromeDriver();

    // Navigate to the web page
    driver.get("http://test-automation-blog.greenfox.academy");

    // Find all elements with the class name "blog-entry-inner"
    List<WebElement> blogEntries = driver.findElements(By.className("blog-entry-inner"));

    // Create a FileWriter and PrintWriter to write the blog entry text into a text file
    try (FileWriter fileWriter = new FileWriter("blog_entries.txt");
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
      // Loop through the blog entries and write the text content of each entry into the text file
      for (WebElement blogEntry : blogEntries) {
        printWriter.println(blogEntry.getText());
      }
      System.out.println("Blog entries written to blog_entries.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Close the WebDriver
    driver.quit();
  }
}


