package demoQA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.image.Kernel;
import java.time.Duration;

public class FormTest {

    WebDriver driver;

    @BeforeEach
    void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    @DisplayName("Formos pildymas")
    void input(){

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys("Agne");

        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Balciunaite");

        WebElement userEmailInput = driver.findElement(By.id("userEmail"));
        userEmailInput.sendKeys("agne.example@gmail.com");

        driver.findElement(By.cssSelector("label[for='gender-radio-2']")).click();

        WebElement userPhoneNumberInput = driver.findElement(By.id("userNumber"));
        userPhoneNumberInput.sendKeys("+3706582476");

        driver.findElement(By.id("dateOfBirthInput")).click();

        Select selectMonth = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        selectMonth.selectByValue("3");
        Select selectYear = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        selectYear.selectByValue("1996");

        driver.findElement(By.cssSelector(".react-datepicker__day--019")).click();

        WebElement userSubjectInput = driver.findElement(By.id("subjectInput"));

        // NUO CIA NEBEUZSIPILDO LENTELE

        userSubjectInput.sendKeys("Maths");
        userSubjectInput.sendKeys(Keys.ENTER);

        userSubjectInput.sendKeys("Economics");
        userSubjectInput.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']")).click();

        driver.findElement((By.id("uploadPicture"))).sendKeys(":C//agnes//Desktop//Pavyzdys");

        driver.findElement(By.cssSelector(".css-tlfecz-indicatorContainer")).click();

        Select selectState = new Select(driver.findElement(By.cssSelector(".css-1uccc91-singleValue")));
        selectState.selectByValue("Uttar Pradesh");

        driver.findElement(By.cssSelector(".css-tlfecz-indicatorContainer")).click();

        Select selectCity = new Select(driver.findElement(By.cssSelector(".css-1uccc91-singleValue")));
        selectCity.selectByValue("Lucknow");



    }
    //    @AfterEach
//    void afterEach() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
