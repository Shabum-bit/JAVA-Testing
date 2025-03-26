package lt.techin;

import net.bytebuddy.implementation.bytecode.ShiftLeft;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoaderTest {

    WebDriver driver;
    WebDriverWait wait;


    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    void testLoader(){
        driver.get("https://automationtesting.co.uk/loadertwo.html");

        WebElement firstParagraphMessage = driver.findElement(By.id("p1"));
        assertEquals("This is an existing paragraph.", firstParagraphMessage.getText());

//        Thread.sleep(8500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("appears")));

    }
    @Test
    void testAction(){

        driver.get("https://automationtesting.co.uk/actions.html");

        Actions actions = new Actions(driver);

        WebElement button = driver.findElement(By.xpath("//div[@class='col-6']//p[@id='doubClickStartText']"));

        actions.moveToElement(button).keyDown(Keys.SHIFT).click().perform();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // arba driver.switchTo().alert();
        assertEquals("The SHIFT key was pressed!", alert.getText());
        alert.accept();
    }
}
