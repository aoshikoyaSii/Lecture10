package Pages.Registeration_Login;

import Models.Gender;
import Models.User;
import Pages.BasePage;
import Pages.Products.ProductDetailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RegistrationPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(RegistrationPage.class);
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#id_gender1")
    private WebElement MrRadBtn;

    @FindBy(css="#id_gender2")
    private WebElement MrsRadBtn;

    @FindBy(css="#customer_firstname")
    private WebElement customerFirstname;

    @FindBy(css="#customer_lastname")
    private WebElement customerLastname;

    @FindBy(css="#email")
    private WebElement email;

    @FindBy(css="#passwd")
    private WebElement password;

    @FindBy(css="days")
    private WebElement daySelector;

    @FindBy(css="months")
    private WebElement monthSelector;

    @FindBy(css="years")
    private WebElement yearSelector;

    //Personal Address details

    @FindBy(css="#firstname")
    private WebElement AddressFirstname;

    @FindBy(css="#lastname")
    private WebElement AddressLastname;

    @FindBy(css="input#company")
    private WebElement companyName;

    @FindBy(css="#address1")
    private WebElement AddressLine1;

    @FindBy(css="address2")
    private WebElement AddressLine2;

    @FindBy(css="#city")
    private WebElement city;

    @FindBy(css="#id_state")
    private WebElement singlestate;

    @FindBy(css="#id_state")
    private List<WebElement> allState;

    @FindBy(css="#postcode")
    private WebElement postcode;

    @FindBy(css="#id_country")
    private WebElement country;

    @FindBy(css="#id_country")
    private WebElement countries;

    @FindBy(css="#other")
    private WebElement textNote;

    @FindBy(css="#phone_mobile")
    private WebElement phone;

    @FindBy(css="#alias")
    private WebElement futureAddress;

    @FindBy(css = "#submitAccount")
    private WebElement submitAccount;

    public void registerUser(User user) {
        logger.info(">>>>>> choose gender randomly <<<<<<<");
        if (user.getGender() == Gender.male) {
            logger.info(">>>>>> Male radio buttom checked <<<<<<<");
            click("#id_gender1");
        } else {
            logger.info(">>>>>> Female radio buttom checked <<<<<<<");
            click("#id_gender2");
        }
        sendKeys(customerFirstname, user.getCustomerFirstname());
        sendKeys(customerLastname, user.getCustomerLastname());
        sendKeys(password, user.getPassword());
        selectRandomDOB();
        sendKeys(companyName, user.getCompanyName());
        sendKeys(AddressLine1, user.getCompanyAddress1());
        sendKeys(city, user.getCity());
        selectRandomState();
        sendKeys(postcode,user.getPostcode());
        chooseCountry(user.getCountries());
        sendKeys(textNote,user.getTextNote());
        sendKeys(phone, user.getPhone());
        sendKeys(futureAddress,user.getFutureAddress());
        click("#submitAccount");
        logger.info(">>>>>>> submit registration button clicked <<<<<<<");
        logger.info(">>>>>>> registration successfully done <<<<<<<<");
    }


}
