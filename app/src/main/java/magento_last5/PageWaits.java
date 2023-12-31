package magento_last5;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class PageWaits {

    private final FluentWait<WebDriver> wait;

    public PageWaits(WebDriver webDriver) {
        wait = initWait(webDriver);
    }

    public List<WebElement> waitUntilAllElementsAreVisible(By by) {
        return (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public WebElement waitForElementToBePresent(By by) {
        return (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable(By by){
        return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    public Alert waitForAlert(){
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    private FluentWait<WebDriver> initWait(WebDriver webDriver) {
        return new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }
}