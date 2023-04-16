import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrivacyStatementTest {

  public static void main(String[] args) {
    // Set the system property for Chrome driver
    System.setProperty("webdriver.chrome.driver", "/Users/sudardavid/Downloads/chromedriver_mac64/chromedriver");

    // Create a new instance of ChromeDriver
    WebDriver driver = new ChromeDriver();

    try {
      // Navigate to the test page
      driver.get("http://test-automation-blog.greenfox.academy/register/");

      // Click on the "Show Privacy Statement" link
      WebElement privacyLink = driver.findElement(By.linkText("Show Privacy Statement"));
      privacyLink.click();

      // Switch to the new window or tab
      for (String handle : driver.getWindowHandles()) {
        driver.switchTo().window(handle);
      }

      // Perform actions in the new window or tab, e.g. validate the privacy statement
      // ...

      // Close the new window or tab and switch back to the original window
      driver.close();
      driver.switchTo().window(driver.getWindowHandles().iterator().next());

      // Navigate back to the original page
      driver.navigate().back();

      // Check the privacy statement checkbox
      WebElement privacyCheckbox = driver.findElement(By.id("um_field_46_privacy_statement"));
      privacyCheckbox.click();

      System.out.println("Test passed: Privacy statement checkbox checked successfully.");
    } catch (Exception e) {
      System.out.println("Test failed: " + e.getMessage());
    } finally {
      // Close the WebDriver instance
      driver.quit();
    }
  }
}






