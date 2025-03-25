package lt.techin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest extends BaseTest {

    @Test
    void positiveInput(){

        CalcPage calcPage = new CalcPage(driver);

        calcPage.setFirstInput("3");

        calcPage.setFunction("minus");

        calcPage.setSecondInput("2");

        calcPage.setSubmit();

        String answer = calcPage.getAnswer();
        assertEquals("5", answer);



    }
}
