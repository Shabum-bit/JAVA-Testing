package lt.techin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    WebDriver driver;

    @BeforeEach
    void beforeEach() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }


    @Test
    @DisplayName("Valid Lgoin")
    void testValidLogin() {

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

    }

    @Test
    @DisplayName("Invalid login")
    void testInvalidLogin(){

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("wrong-password");

        driver.findElement(By.id("login-button")).click();

        WebElement errorMessage = driver.findElement(By.className("error-message-container"));
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(expectedMessage, errorMessage.getText());

    }

    @Test
    @DisplayName("Locked out user")
    void testLockedOutUser() {

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("locked_out_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        WebElement errorMessage = driver.findElement(By.className("error-message-container"));
        String expectedMessage = "this user has been locked out";
        assertEquals(expectedMessage, errorMessage.getText());
    }
     @ParameterizedTest
     
     // NESIGAUNA MAN SU TUO KELIU

     @CsvFileSource(resources = "/src/test/java/lt/techin/logins.csv", numLinesToSkip = 1)
     void testFileLogins(String USER_NAME, String PASSWORD){

         WebElement inputUsername = driver.findElement(By.id("user-name"));
         inputUsername.sendKeys(USER_NAME);

         WebElement inputPassword = driver.findElement(By.id("password"));
         inputPassword.sendKeys(PASSWORD);

         driver.findElement(By.id("login-button")).click();

         assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());;
     }

    @Test
    @DisplayName("Time check")
    void testTimeCheck() {
        assertTimeout(Duration.ofSeconds(2), () -> {

            WebElement inputUsername = driver.findElement(By.id("user-name"));
            inputUsername.sendKeys("performance_glitch_user");

            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();

            assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        });
    }
    @AfterEach
    void afterEach() {
        if (driver != null) {
            driver.quit();
        }
    }
}



