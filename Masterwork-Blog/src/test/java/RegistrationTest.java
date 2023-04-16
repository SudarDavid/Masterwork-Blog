import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegistrationTest {
  private WebDriver driver;
  private String registerPageUrl = "http://test-automation-blog.greenfox.academy/register/";

  @BeforeTest
  public void setUp() {
    // Set up the WebDriver and open the registration page
    System.setProperty("webdriver.chrome.driver", "/Users/sudardavid/Downloads/chromedriver_mac64/chromedriver"); // Update path to your chromedriver executable
    driver = new ChromeDriver();
    driver.get(registerPageUrl);
  }

  @AfterTest
  public void tearDown() {
    // Close the WebDriver
    driver.quit();
  }

  @Test
  public void testRegistrationSuccess() {
    // Enter valid registration details
    String username = "testuser";
    String firstName = "John";
    String lastName = "Doe";
    String email = "testuser@example.com";
    String password = "Test1234";

    driver.findElement(By.id("user_login-46")).sendKeys(username);
    driver.findElement(By.id("first_name-46")).sendKeys(firstName);
    driver.findElement(By.id("last_name-46")).sendKeys(lastName);
    driver.findElement(By.id("user_email-46")).sendKeys(email);
    driver.findElement(By.id("user_password-46")).sendKeys(password);
    driver.findElement(By.id("confirm_user_password-46")).sendKeys(password);
    driver.findElement(By.id("um_field_46_privacy_statement")).click();
    driver.findElement(By.id("um-submit-btn")).click();

    // Verify successful registration by checking if an element with ID "menu-item-85" is displayed
    boolean menu85Displayed = driver.findElement(By.id("menu-item-85")).isDisplayed();
    Assert.assertTrue(menu85Displayed, "Element with ID 'menu-item-85' not displayed after successful registration");
  }

  @Test
  public void testRegistrationFailure() {
    // Enter invalid registration details
    String username = "testuser";
    String firstName = "John";
    String lastName = "Doe";
    String email = "testuser@example.com";
    String password = "test1234"; // Providing invalid password

    driver.findElement(By.id("user_login-46")).sendKeys(username);
    driver.findElement(By.id("first_name-46")).sendKeys(firstName);
    driver.findElement(By.id("last_name-46")).sendKeys(lastName);
    driver.findElement(By.id("user_email-46")).sendKeys(email);
    driver.findElement(By.id("user_password-46")).sendKeys(password);
    driver.findElement(By.id("confirm_user_password-46")).sendKeys("invalid_password");
    driver.findElement(By.id("um_field_46_privacy_statement")).click();
    driver.findElement(By.id("um-submit-btn")).click();

    // Verify failed registration by checking if URL after failed registration is the same registration page URL
    String currentUrl = driver.getCurrentUrl();
    Assert.assertEquals(currentUrl, registerPageUrl, "URL after failed registration is not the registration page URL");
  }
}



