package Pages.Products;

import Models.PaymentOptions;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentProcessPage extends BasePage {

    private static Logger logger = LoggerFactory.getLogger(PaymentProcessPage.class);

    public PaymentProcessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".bankwire")
    private WebElement payByWire;

    @FindBy(css = ".cheque")
    private WebElement payByCheck;

    @FindBy(xpath="//*[contains(text(),'I confirm my order')]")
    private WebElement iConfirmOrder;

    @FindBy(xpath="//button[@name='processAddress']")
    private WebElement checkOutAfterLoginIn;

    @FindBy(css="#uniform-cgv")
    private WebElement termAndCondition;

    @FindBy(css="button.standard-checkout")
    private WebElement getProceedToChkOut2;

    public PaymentProcessPage paymentAdressValidationCheckOut(){
        logger.info(">>>>>>> proceed from payment address validation <<<<<<<");
        click(checkOutAfterLoginIn);

        return this;
    }

    public PaymentProcessPage termsCondition(){
        logger.info(">>>>>>> accept terms and conditions <<<<<<<");

        click(termAndCondition);
        return this;
    }

    public PaymentProcessPage shippingProceedCheckout(){
        logger.info(">>>>>>> proceed from shipping information validation <<<<<<<");
        click(getProceedToChkOut2);
        return this;
    }

    public PaymentProcessPage paymentsOptionSelector() {
        logger.info(">>>>>>> choose method of payment <<<<<<<");
        if (PaymentOptions.getSelectedPaymentOptions().equals(PaymentOptions.payByBankWire)) {
            logger.info(">>>>>>> pay by bank wire method choosen <<<<<<<");
            click(payByWire);
        } else {
            logger.info(">>>>>>> pay by bank check method choosen <<<<<<<");
            click(payByCheck);
        }
        return this;
    }

    public PaymentProcessPage confirmPayment(){
        logger.info(">>>>>>> proceed to confirm the order <<<<<<<");
        click(iConfirmOrder);
        logger.info(">>>>>>>> order completed successfully <<<<<<<<<");
        return this;
    }


}
