package lt.techin;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://teststore.automationtesting.co.uk/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

//    @AfterEach
//    void afterEach() {
//        if (driver != null) {
//            driver.quit();
//        }
//
//    }
}
