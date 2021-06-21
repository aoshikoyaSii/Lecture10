package Pages.Registeration_Login;
import Models.User;
import Pages.BasePage;
import Pages.HomePage;
import Pages.Products.ProductCart;
import Pages.Products.ProductDetailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(ProductDetailsPage.class);
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private User user;

    @FindBy(id="email_create")
    private WebElement email_create;

    @FindBy(id="SubmitCreate")
    private WebElement createAccountBtn;

    @FindBy(id="email")
    private WebElement emailAdd;

    @FindBy(id="passwd")
    private WebElement password;

    @FindBy(id="SubmitLogin")
    private WebElement SignIn;


    public RegistrationPage createAnAccount(String email) {
        logger.info(">>>>>> initialize create account <<<<<< ");
        logger.info(">>>>>> enter email >>>>>>>>");
        sendKeys(email_create, email);
        click("SubmitCreate");
        logger.info(">>>>>> create account button clicked >>>>>>>>");
        return new RegistrationPage(getDriver());
    }


    public ProductCart logInAsExistingUser( User user){
        logger.info(">>>>>> initialize register as Existing user <<<<<< ");
        logger.info(">>>>>> enter email >>>>>>>>");
        sendKeys(emailAdd, System.getProperty("email"));
        logger.info(">>>>>> enter password >>>>>>>>");
        sendKeys(password,System.getProperty("password"));
        click("#SubmitLogin");
        logger.info(">>>>>> signin button clicked >>>>>>>>");
        return new ProductCart(getDriver());
    }


}
