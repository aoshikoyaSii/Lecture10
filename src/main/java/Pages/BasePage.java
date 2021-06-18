package Pages;

import Pages.Listerner.WebListener;
import Pages.Registeration_Login.RegistrationPage;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class BasePage {
    private final WebDriver driver;
    private EventFiringMouse eventFiringMouse;
    protected WebListener webListener;
    Logger logger = LoggerFactory.getLogger(BasePage.class);
    FluentWait wait;
    WebElement el;

    @FindBy(css="#id_state")
    private WebElement singlestate;

    @FindBy(css="select#days")
    private WebElement daySelector;

    @FindBy(css="select#months")
    private WebElement monthSelector;

    @FindBy(css="select#years")
    private WebElement yearSelector;

    @FindBy(css="#id_country")
    private WebElement country;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
    }

    WebElement initWaitsStart(WebElement elementIdentifier){
        logger.info(">>>>>>> fluent wait initialized <<<<<<<< ");
        Wait<WebDriver> wait =
                new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(5))
                        .ignoring(NoSuchElementException.class);
        System.out.println(wait);
        return wait.until(new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver) {
                WebElement locateTheEl = wait.until(ExpectedConditions.visibilityOf(elementIdentifier));

                if(WrapsElement.class.isAssignableFrom(locateTheEl.getClass()))
                    driver = ((WrapsDriver)((WrapsElement)locateTheEl).getWrappedElement()).getWrappedDriver();
                else
                    driver = ((WrapsDriver)locateTheEl).getWrappedDriver();

                return locateTheEl;
            }
        });
    }

    public void click(WebElement element) {
        WebElement el = (element.isDisplayed() || element.isEnabled()) ? element : null;
        initWaitsStart(el);
        el.click();
    }

    public void mouseHover(WebElement element) {
        logger.debug("mouseHover perform on the object: " + element.getText());
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item =(Locatable) element;
        Coordinates coordinates = item.getCoordinates();

        eventFiringMouse.mouseMove(coordinates);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }

    public RegistrationPage selectRandomState(){
        Select chooseState = new Select(singlestate);
        WebElement newState = getRandomEl(chooseState.getOptions());
        chooseState(newState.getText());
        return (RegistrationPage) this;
    }


    private RegistrationPage chooseState(String text) {
        ChooseFromVisibleText(text, singlestate);
        return (RegistrationPage) this;
    }


    public RegistrationPage chooseCountry(String val){
        ChooseFromVisibleText(val, country);
        return (RegistrationPage) this;
    }


    public RegistrationPage selectRandomDOB(){
        Select chooseDay = new Select(daySelector);
        WebElement day = getRandomEl(chooseDay.getOptions());
        ChooseFromVisibleText(day.getText(),daySelector);

        Select chooseMonth = new Select(monthSelector);
        WebElement month = getRandomEl(chooseMonth.getOptions());
        ChooseFromVisibleText(month.getText(),monthSelector);

        Select chooseYear = new Select(yearSelector);
        WebElement year = getRandomEl(chooseYear.getOptions());
        ChooseFromVisibleText(year.getText(),yearSelector);
        return (RegistrationPage) this;
    }

    public RegistrationPage ChooseFromVisibleText (String val, WebElement el){
        new Select(el).selectByVisibleText(val);
        return (RegistrationPage) this;
    }


    public WebElement getRandomEl(List<WebElement> list){
        Random random = new Random();
        int value = random.nextInt(list.size()-1);
        return list.get(value);

    }

}
