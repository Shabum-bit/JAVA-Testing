package lt.techin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignUpTest extends BaseTest {

    @Test
    void signUp(){

        SignUpPage signUpPage = new SignUpPage(driver);

        //1

        signUpPage.setSignInButton();

        signUpPage.setCreateAccountButton();

        //2
RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.setTitleRadio();

        registrationPage.setFirstName("Agne");

        registrationPage.setLastName("Balciunaite");

        String email = "ag" + System.currentTimeMillis() + "@mail.com";
        registrationPage.setEmail(email);

        registrationPage.setPassword("Juhuuu1230");

        registrationPage.setDate("04/19/1996");

        registrationPage.setConditionsRadio();

        registrationPage.setSaveButton();

        //3

        signUpPage.setAccountPageButton();

        String userAccountPage = signUpPage.getUserAccountPage();
        assertEquals("Your account", userAccountPage);

        String userAccountName = signUpPage.getUserAccountName();
        assertEquals("Agne Balciunaite", userAccountName);

        //4

        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);

        personalInformationPage.setSigOutButton();

        personalInformationPage.setEmailLogIn(email);

        personalInformationPage.setPasswordLogIn("Juhuuu1230");

        personalInformationPage.setSignInButtonRepeat();

        personalInformationPage.setInformation();

        String firstNameInformation = personalInformationPage.getFirstNameInformation();
        assertEquals("Agne", firstNameInformation);

        String lastNameInformation = personalInformationPage.getLastNameInformation();
        assertEquals("Balciunaite", lastNameInformation);

        String emailInfirmation = personalInformationPage.getEmailInformation();
        assertEquals("ag.shabum@gmail.com", emailInfirmation);
    }

}
