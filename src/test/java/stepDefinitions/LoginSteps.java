
package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.Base;
import Base.User;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class LoginSteps extends Base {
    WebDriver driver;
    // User user = new User();

    @Before
    public void startup() {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
    }

    @Given("I am on the sign-up page")
    public void I_am_on_the_sign_up_page() {
        driver.findElement(By.id("signin2")).click();
    }

    @When("I enter a valid username")
    public void I_enter_a_valid_username() {
        String username = generateRandomString(10, "username_"); // Generates a random username of 10 characters.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modaWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        modaWebElement.findElement(By.id("sign-username")).sendKeys(username);
    }

    @Then("I should see a success message")
    public void I_should_see_a_success_message() {
    }

    @When("I click the sign-up button")
    public void I_click_the_sign_up_button() {
        WebElement signup_button = driver
                .findElement(By.cssSelector("#signInModal > div > div > div.modal-footer > button.btn.btn-primary"));
        signup_button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @When("I enter a valid password")
    public void I_enter_a_valid_password() {
        String password = generateRandomString(10, "Password_"); // Generates a random password of 10 characters.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modaWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        modaWebElement.findElement(By.id("sign-password")).sendKeys(password);
    }
    @Given("^User is on the login page$")
    public void user_is_on_login_page() {
        driver.findElement(By.id("login2")).click();
    }
 
    @When("^User enters valid username and password$")
    public void user_enters_credentials() {
    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modaWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
        // int index;
        modaWebElement.findElement(By.id("loginusername")).sendKeys("subhas1");
        modaWebElement.findElement(By.id("loginpassword")).sendKeys("subhas");
    }


    @When("User enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String string, String string2) {
     String usernmae =User.getUsername(Integer.parseInt(string));
     String password =User.getPassword(Integer.parseInt(string));

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement modaWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
    // int index;
    modaWebElement.findElement(By.id("loginusername")).sendKeys(usernmae);
    modaWebElement.findElement(By.id("loginpassword")).sendKeys(password);
}


    @Then("^User is navigated to the homepage$")
    public void user_navigated_to_homepage() {
    }

    @When("User clicks on the login button")
    public void User_clicks_on_the_login_button() {
        WebElement login_button = driver
                .findElement(By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary"));
        login_button.click();
    }


    @When("I enter a valid username {string}")
    public void I_enter_a_valid_username(String s) {


        String username = generateRandomString(10, "username_"); // Generates a random username of 10 characters.
        User.setUsername(username);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modaWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        modaWebElement.findElement(By.id("sign-username")).sendKeys(username);    }


    @When("I enter a valid password {string}")
    public void I_enter_a_valid_password(String s) {
        String password = generateRandomString(10, "Password_"); // Generates a random password of 10 characters.
        User.setPassword(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modaWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        modaWebElement.findElement(By.id("sign-password")).sendKeys(password);    }

   
    @AfterStep
    public void addScreenshot(Scenario scenario) throws InterruptedException {
        Thread.sleep(500);
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
    }

    @After
    public void teaarDown() {
        driver.quit();
    }
}