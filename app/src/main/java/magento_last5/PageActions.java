package magento_last5;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class PageActions  {
    private final WebDriver webDriver;

    public PageActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageWaits pageWaits = new PageWaits(webDriver);
    }

    public void click(By by) {
        webDriver.findElement(by).click();
    }

    public void type(By by, String value) {
        webDriver.findElement(by).clear();
        webDriver.findElement(by).sendKeys(value);
    }

    public void navigateTo(String url) {
        webDriver.get(url);
    }

    public void refreshPage() {
        webDriver.navigate().refresh();
    }
    public void executeJS(String script, Object... args) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript(script, args);
    }

    public void moveToElement(By by){
        Actions builder = new Actions(webDriver);
        WebElement element = webDriver.findElement(by);
        builder.moveToElement(element).pause(Duration.ofSeconds(5)).perform();
    }

}