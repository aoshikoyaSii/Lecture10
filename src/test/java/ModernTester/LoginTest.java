package ModernTester;

import Models.User;
import TestBaseFolder.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import providers.UserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest extends TestBase {
    private User user;
    private String expectedSignInText;


    @Test
    public void LoginExistingUser(){
        expectedSignInText = (user.getCustomerFirstname()+" "+ user.getCustomerLastname());
        homePage.getMenu().openLoginPage().logInAsExistingUser(user);
        assertThat(homePage.getMenu().getUserName(),
                equalTo(expectedSignInText));
        return;
    }




}
