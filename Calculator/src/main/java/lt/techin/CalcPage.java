package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CalcPage extends BasePage {

    public CalcPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "number1")
    private WebElement firstInput;

    @FindBy(id = "function")
    private WebElement functionSymbols;

    @FindBy(id = "number2")
    private WebElement secondInput;

    @FindBy(id = "calculate")
    private WebElement submit;

    @FindBy(id = "answer")
    private WebElement answer;

    void setFirstInput(String input) {
        firstInput.sendKeys(input);
    }

    void setFunction(String operation) {
        Select functionSelect = new Select(functionSymbols);
        functionSelect.selectByValue(operation);
    }

    void setSecondInput(String input) {
        secondInput.sendKeys(input);
    }

    void setSubmit() {
        submit.click();
    }

    public String getAnswer() {
       return answer.getText();
    }

}

