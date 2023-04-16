import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;

public class LoginTest {
  private WebDriver driver;

  @BeforeTest
  public void setUp() {
    // Set up the WebDriver and open the login page
    System.setProperty("webdriver.chrome.driver", "/Users/sudardavid/Downloads/chromedriver_mac64/chromedriver");
    driver = new ChromeDriver();
    driver.get("http://test-automation-blog.greenfox.academy/wp-login.php");
  }

  @AfterTest
  public void tearDown() {
    // Close the WebDriver
    driver.quit();
  }

  @Test
  public void testLoginSuccess() {
    // Enter valid username and password
    driver.findElement(By.id("user_login")).sendKeys("admin1234");
    driver.findElement(By.id("user_pass")).sendKeys("Admin1234");
    driver.findElement(By.id("wp-submit")).click();

    // Verify successful login and landing on main page
    String currentUrl = driver.getCurrentUrl();
    assertEquals("http://test-automation-blog.greenfox.academy/", currentUrl, "Login was not successful. Not landed on the main page.");
  }

  @Test
  public void testLoginFailure() {
    // Enter invalid username and password
    driver.findElement(By.id("user_login")).sendKeys("invalidusername");
    driver.findElement(By.id("user_pass")).sendKeys("invalidpassword");
    driver.findElement(By.id("wp-submit")).click();

    // Verify failed login
    String errorMessage = driver.findElement(By.id("login_error")).getText();
    assertEquals("Unknown username. Check again or try your email address.", errorMessage, "Error message is not as expected");
  }
}





