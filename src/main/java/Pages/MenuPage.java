package Pages;

import Pages.Products.ProductDetailsPage;
import Pages.Products.ProductListPage;
import Pages.Registeration_Login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuPage extends  BasePage{

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="a.login")
    private WebElement signInBtn;

    @FindBy(css=".header_user_info > a > span")
    private WebElement userNameSurname;

    public String getUserName() {
        return userNameSurname.getText();
    }

    public LoginPage openLoginPage() {
        click("a.login");
        return new LoginPage(getDriver());
    }

    @FindBy(css = ".product_list > li")
    private List<WebElement> allProducts;

        public ProductListPage getRandomProductFromListOfProduct() { //returns single product
            logger.info(">>>>>>>>> random product auntomatically picked");
            return new ProductListPage(getDriver(), getRandomElement(allProducts));
        }


}
