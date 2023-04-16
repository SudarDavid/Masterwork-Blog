import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewDataInputTest {
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

    // Click on Continue Reading link
    WebElement continueReadingLink = driver.findElement(By.xpath("//article[@id='post-38']//a[@title='Continue Reading'][normalize-space()='Continue Reading']"));
    continueReadingLink.click();

    // Enter random text in the comment text area
    WebElement commentTextArea = driver.findElement(By.xpath("//textarea[@id='comment']"));
    commentTextArea.sendKeys("This is a test comment");

    // Submit the comment
    WebElement submitButton = driver.findElement(By.xpath("//input[@id='comment-submit']"));
    submitButton.click();

    // Assert the presence of the comment
    WebElement commentElement = driver.findElement(By.xpath("//article[@class='comment byuser comment-author-admin1234 even thread-even depth-1 comment-body']"));
    assert(commentElement.isDisplayed());

    // Close the browser window
    driver.quit();
  }
}
