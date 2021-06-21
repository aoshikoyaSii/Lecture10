package ModernTester;

import Models.User;
import Pages.Products.*;
import TestBaseFolder.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import providers.UserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProductTest extends TestBase {

    ProductListPage productListPage;
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    ProductCart productCart = new ProductCart(driver);
    PaymentProcessPage paymentProcess = new PaymentProcessPage(driver);
    AssertRegistrationConfirmation assertRegistrationConfirmation = new AssertRegistrationConfirmation(driver);
    User user = new UserFactory().registeringNewUser();


    @Test
    public void Test1() {
        productListPage = homePage.getMenu()
                .getRandomProductFromListOfProduct();

        productDetailsPage = productListPage
                .clickOnSelectedProduct()
                .AddToCart()
                .proceedToCheckout();


        productCart.redirectToLogInPage()
                   .logInAsExistingUser(user);

        paymentProcess
                   .paymentAdressValidationCheckOut()
                   .termsCondition()
                   .shippingProceedCheckout()
                   .paymentsOptionSelector()
                    .confirmPayment();

        assertRegistrationConfirmation.confirmText();
    }






}
