package ModernTester;

import Models.User;
import TestBaseFolder.TestBase;
import org.junit.jupiter.api.Test;
import providers.UserFactory;

public class RegistrationTest extends TestBase {

    User user = new UserFactory().registeringNewUser();
    @Test
    public void shouldRegisterNewUser() {
        homePage.getMenu()
                .openLoginPage()
                .createAnAccount(user.getEmail())
                .registerUser(user);
    }
}
