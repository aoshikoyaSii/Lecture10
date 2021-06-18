package Pages.Products;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    Logger logger = LoggerFactory.getLogger(ProductDetailsPage.class);

    @FindBy(css="#add_to_cart > button")
    private WebElement  addToCart;

    @FindBy(css=".button-container .button-medium")
    private WebElement proceedToCheckout;


    public ProductDetailsPage AddToCart(){
        logger.info(">>>>>>>>> click add product to cart button");
            //fluentWaitMethod("#add_to_cart > button");
            click(addToCart);
        return new ProductDetailsPage(getDriver());
    }


    public ProductDetailsPage proceedToCheckout(){
        logger.info(">>>>>>>>> click proceed to checkout button");
        //fluentWaitMethod(".button-container .button-medium");
        click(proceedToCheckout);
        return new ProductDetailsPage(getDriver());
    }

}