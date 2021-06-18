package Pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final MenuPage menuPage;

    public HomePage(WebDriver driver) {
        super(driver);
        this.menuPage = new MenuPage(driver);

    }

    public MenuPage getMenu() {
        return menuPage;
    }

}