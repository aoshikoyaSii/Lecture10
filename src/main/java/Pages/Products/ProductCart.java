package Pages.Products;

import Pages.BasePage;
import Pages.Registeration_Login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductCart extends BasePage {
    Logger logger = LoggerFactory.getLogger(ProductCart.class);
    public ProductCart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="a.standard-checkout")
    private WebElement proceedToChkOut1;


    public LoginPage redirectToLogInPage(){ //proceedChkTwo
        try {
            logger.info(">>>>>>> currently trying for Null Exception Error <<<<<<<<<<");
            //fluentWaitMethod("a.standard-checkout");
            logger.info(">>>>>>> click proceed button to redirect to login page <<<<<<<<<<");
            click(proceedToChkOut1);
            logger.info(">>>>>>> redirected to login page now <<<<<<<<<<");
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return new LoginPage(getDriver());
    }

    }
