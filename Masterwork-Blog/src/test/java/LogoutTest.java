import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LogoutTest {
  public static void main(String[] args) {
    // Set the path to the chromedriver executable
    System.setProperty("webdriver.chrome.driver", "/Users/sudardavid/Downloads/chromedriver_mac64/chromedriver");

    // Create a new instance of ChromeDriver
    WebDriver driver = new ChromeDriver();

    // Navigate to the login page
    driver.get("http://test-automation-blog.greenfox.academy/wp-login.php");

    // Find the username and password fields and enter your credentials
    WebElement usernameField = driver.findElement(By.id("user_login"));
    WebElement passwordField = driver.findElement(By.id("user_pass"));
    WebElement loginButton = driver.findElement(By.id("wp-submit"));

    // Enter your username and password here
    String username = "admin1234";
    String password = "Admin1234";

    usernameField.sendKeys(username);
    passwordField.sendKeys(password);

    // Click on the login button
    loginButton.click();

    // Wait for the login to complete
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Find the logout link and click on it
    WebElement logoutLink = driver.findElement(By.id("menu-item-72"));
    logoutLink.click();
    System.out.println("Clicked on initial logout link");

    // Find the "log out" link on the confirmation page and click on it
    WebElement confirmLogoutLink = driver.findElement(By.xpath("//a[normalize-space()='log out']"));
    confirmLogoutLink.click();
    System.out.println("Clicked on confirm logout link");

    // Assert that logout was successful by checking if the login page is displayed again
    WebElement loginForm = driver.findElement(By.id("loginform"));
    Assert.assertTrue(loginForm.isDisplayed(), "Logout was unsuccessful");

    // Close the web driver
    driver.close();
  }
}




