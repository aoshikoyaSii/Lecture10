package Pages.Products;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProductListPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(ProductListPage.class);
    public ProductListPage(WebDriver driver, WebElement productList) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(productList), this);
    }

    @FindBy(css="a.product-name")
    private WebElement name;

    public String getName(){
        return name.getText();
    }

    public ProductDetailsPage clickOnSelectedProduct(){
        logger.info(">>>>>> click on product randomly selected by our random product generator <<<<<<<");
        click(name);
        return new ProductDetailsPage(getDriver());
    }


}
