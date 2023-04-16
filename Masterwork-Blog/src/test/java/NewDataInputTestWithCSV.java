import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class NewDataInputTestWithCSV {
  public static void main(String[] args) throws IOException {
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

    // Read data from CSV file
    String csvFile = "/Users/sudardavid/Desktop/Masterwork/Masterwork-Blog/src/test/java/testdata.csv"; // Replace with the name of your CSV file
    Reader reader = new FileReader(csvFile);
    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader().withDelimiter(';'));
    for (CSVRecord record : csvParser) {
      String name = record.get("Name");
      String age = record.get("Age");
      String gender = record.get("Gender");

      // Enter data in the comment text area
      WebElement commentTextArea = driver.findElement(By.xpath("//textarea[@id='comment']"));
      commentTextArea.sendKeys("Name: " + name + ", Age: " + age + ", Gender: " + gender);

      // Submit the comment
      WebElement submitButton = driver.findElement(By.xpath("//input[@id='comment-submit']"));
      submitButton.click();

      // Assert the presence of the comment
      WebElement commentElement = driver.findElement(By.xpath("//article[@class='comment byuser comment-author-admin1234 even thread-even depth-1 comment-body']"));
      assert (commentElement.isDisplayed());

      // Clear the comment text area for the next iteration
      commentTextArea.clear();
    }

    // Close the CSV parser, reader, and the browser
    csvParser.close();
    reader.close();
    driver.quit();
  }
}





