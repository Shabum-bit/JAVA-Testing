package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInformationPage extends BasePage{


    @FindBy(xpath = "//a[@class='logout hidden-sm-down']")
    private WebElement sigOutButton;

    @FindBy(xpath = "//input[@id='field-email']")
    private WebElement emailLogIn;

    @FindBy(xpath = "//input[@id='field-password']")
    private WebElement passwordLogIn;

    @FindBy(xpath = "//button[@id='submit-login']")
    private WebElement signInButtonRepeat;

    @FindBy(xpath = "//a[@id='identity-link']//span[@class='link-item']")
    private WebElement information;

    @FindBy(xpath = "//input[@id='field-firstname']")
    private WebElement firstNameInformation;

    @FindBy(xpath = "//input[@id='field-lastname']")
    private WebElement lastNameInformation;

    @FindBy(xpath = "//input[@id='field-email']")
    private WebElement emailInformation;

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    void setSigOutButton(){
        sigOutButton.click();
    }
    void setEmailLogIn(String input){
        emailLogIn.sendKeys(input);
    }
    void setPasswordLogIn(String input){
        passwordLogIn.sendKeys(input);
    }
    void  setSignInButtonRepeat(){
        signInButtonRepeat.click();
    }
    void setInformation(){
        information.click();
    }
    public String getFirstNameInformation(){
        return firstNameInformation.getDomAttribute("value");
    }
    public String getLastNameInformation(){
        return lastNameInformation.getDomAttribute("value");
    }
    public String getEmailInformation(){
        return emailInformation.getDomAttribute("value");
    }
}
