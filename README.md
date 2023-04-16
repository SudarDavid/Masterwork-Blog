# Masterwork-Blog

This is a program that performs automated testing on a web application. It includes various test scenarios to validate the functionality of the web application.

## Prerequisites

- Java Development Kit (JDK) installed on your machine
- Selenium WebDriver library installed
- ChromeDriver (or other WebDriver) executable file downloaded and placed in a directory included in the system's PATH environment variable

## Installation

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Update the configuration file (if applicable) with the appropriate settings for your web application.
4. Build the project using your preferred build tool (e.g., Maven or Gradle) to download the necessary dependencies.

## Running the Program

1. Open a terminal or command prompt.
2. Navigate to the project directory.
3. Execute the main class or test class that corresponds to the desired test scenario.
4. Monitor the test execution in the console or log files.
5. Review the test results to verify the success or failure of each test.

## Test Scenarios

The program includes the following test scenarios:

- Registration: Covers both successful and unsuccessful attempts to register.
- Login: Covers both successful and unsuccessful attempts to login.
- Privacy Statement: Opens the Privacy Statement page and checks the box.
- Listing Data: Executes a data listing from the web application and validates the results.
- Pagination: Navigates to the next page of a data list that spans multiple pages.
- Input of New Data: Performs new data input and validates the success of the operation.
- Repetitive Data Entry from External Source: Reads data from a CSV file and performs parameterized testing with at least 3 data sets.
- Existing Data Modification: Modifies existing data and validates the success of the change.
- Deleting Data: Deletes data and validates the success of the operation.
- Saving Data from the Web Application: Saves a list of data from the web application into a text file.
- Logout

## Manual and Automated Test Running

The program includes both manual and automated test scenarios. For manual testing, follow the instructions provided in the test scenarios to perform the required actions on the web application manually and verify the results.

For automated testing, the program uses Selenium WebDriver to automate interactions with the web application. Test scenarios are written in Java using the Selenium WebDriver library and executed using a build tool (e.g., Maven or Gradle) and a test runner (e.g., JUnit or TestNG). Automated test results can be reviewed in the console or log files.

## Test Documentation

Test documentation, including the test scenarios, test results, and any issues or observations, should be documented in a Google spreadsheet or any other preferred format for effective communication and collaboration with the team.

## License

This project is licensed under the [License Name] License - see the [LICENSE](LICENSE) file for details.

