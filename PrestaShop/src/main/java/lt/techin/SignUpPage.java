package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    // 1

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
        private WebElement signInButton;

    @FindBy(xpath = "//a[normalize-space()='No account? Create one here']")
        private WebElement createAccountButton;

    //2

    @FindBy(xpath = "//span[normalize-space()='Agne Balciunaite']")
    private WebElement accountPageButton;

    @FindBy(xpath = "//h1[normalize-space()='Your account']")
    private WebElement userAccountPage;

    @FindBy(xpath = "//span[normalize-space()='Agne Balciunaite']")
    private WebElement userAccountName;



    //1

    void setSignInButton(){
        signInButton.click();
    }
    void setCreateAccountButton() {
        createAccountButton.click();
    }

    //2

    void setAccountPageButton(){
        accountPageButton.click();
    }
    public String getUserAccountPage(){
        return userAccountPage.getText();
    }
    public String getUserAccountName(){
        return userAccountName.getText();

    }

}
