package ModernTester;

import Models.User;
import Pages.Registeration_Login.LoginPage;
import Pages.Registeration_Login.RegistrationPage;
import TestBaseFolder.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import providers.UserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MainPageCaller extends TestBase {
    User user;
    LoginPage loginPage = new LoginPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);
    private String expectedSignInText;
    @FindBy(css="SubmitLogin")
    private WebElement SignIn;


    // this method is definitely optional
    @Test
    public void ExecutePageOperation(){
        shouldRegisterNewUser();
        LoginExistingUser();
    }

    @Test
    private void shouldRegisterNewUser() {
            user = new UserFactory().registeringNewUser();
            homePage.getMenu()
                    .openLoginPage()
                    .createAnAccount(user.getEmail())
                    .registerUser(user);
            return;
    }

    @Test
    public void LoginExistingUser(){
        user = new UserFactory().registeringNewUser();
        expectedSignInText = user.getCustomerFirstname()+" "+ user.getCustomerLastname();
        homePage.getMenu()
                .openLoginPage()
                .logInAsExistingUser(user);
                 SignIn.click();

        assertThat(homePage.getMenu().getUserName(),
                equalTo(expectedSignInText));
        return;
    }
}
