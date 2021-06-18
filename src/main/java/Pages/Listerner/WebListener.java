package Pages.Listerner;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebListener extends AbstractWebDriverEventListener  {
    Logger logger = LoggerFactory.getLogger(WebListener.class);


    public void beforeClickOn(WebElement el, WebDriver  driver){
        logger.info(">>>>>>>  click element: " +el.getText() + " <<<<<<<<<");
    }

    public void afterClickOn(WebElement el, WebDriver  driver){
        logger.info(">>>>>>>  after click: click on: " +" <<<<<<<<<");
    }


}
