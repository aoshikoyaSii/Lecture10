package Pages.Products;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AssertRegistrationConfirmation extends BasePage {
    public AssertRegistrationConfirmation(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".cheque-indent")
    private WebElement orderCompleteText;

    public AssertRegistrationConfirmation confirmText(){
        assertThat(orderCompleteText.getText(), equalTo(System.getProperty("ordercomplete")));
        return this;
    }
}
