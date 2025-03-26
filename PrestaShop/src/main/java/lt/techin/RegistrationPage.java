package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    @FindBy(xpath = "//input[@id='field-id_gender-2']")
    private WebElement titleRadio;

    @FindBy(xpath = "//input[@id='field-firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='field-lastname']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='field-email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='field-password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='field-birthday']")
    private WebElement date;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement conditionsRadio;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;


        public RegistrationPage(WebDriver driver) {
            super(driver);
        }

    void setTitleRadio(){
        titleRadio.click();
    }
    void setFirstName(String input){
        firstName.sendKeys(input);
    }
    void setLastName(String input){
        lastName.sendKeys(input);
    }
    void setEmail(String input){
        email.sendKeys(input);
    }
    void setPassword(String input){
        password.sendKeys(input);
    }
    void setDate(String input){
        date.sendKeys(input);
    }
    void setConditionsRadio(){
        conditionsRadio.click();
    }
    void setSaveButton(){
        saveButton.click();
    }
}
