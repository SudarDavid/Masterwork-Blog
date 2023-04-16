import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExistingDataModificationTest {
  public static void main(String[] args) {
    // Set the system property for the Chrome driver
    System.setProperty("webdriver.chrome.driver", "/Users/sudardavid/Downloads/chromedriver_mac64/chromedriver");

    // Create an instance of ChromeDriver
    WebDriver driver = new ChromeDriver();

    // Navigate to the login page
    driver.get("http://test-automation-blog.greenfox.academy/wp-login.php");

    // Enter the username and password and click on login
    WebElement usernameInput = driver.findElement(By.id("user_login"));
    WebElement passwordInput = driver.findElement(By.id("user_pass"));
    WebElement loginButton = driver.findElement(By.id("wp-submit"));
    usernameInput.sendKeys("admin1234");
    passwordInput.sendKeys("Admin1234");
    loginButton.click();

    // Navigate to the account page
    WebElement accountPage = driver.findElement(By.id("menu-item-85")); // Update with the provided ID
    accountPage.click();

    // Delete the existing first name
    WebElement firstNameInput = driver.findElement(By.id("first_name"));
    firstNameInput.clear();

    // Enter a random first name
    String randomFirstName = "John"; // Replace with your desired random first name
    firstNameInput.sendKeys(randomFirstName);

    // Click on the update button
    WebElement updateButton = driver.findElement(By.id("um_account_submit_general"));
    updateButton.click();

    // Assert that the first name has been changed successfully
    WebElement firstNameElement = driver.findElement(By.id("first_name"));
    String updatedFirstName = firstNameElement.getAttribute("value");
    assert (updatedFirstName.equals(randomFirstName));

    // Close the browser
    driver.quit();
  }
}


