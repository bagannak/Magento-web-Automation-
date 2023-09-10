package magento_last5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    PageWaits waits = new PageWaits(driver);
    PageActions actions = new PageActions(driver);

    private final By selectStyleLocator = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[2]/ol/li[1]/a");
    private final By selectSizeLocator = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div[3]/div[1]/div[2]/div/div/a[3]/div");
    private final By selectPriceLocator = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div[3]/div[1]/div[2]/ol/li[1]");
    private final By styleOptionLocator = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[2]/ol/li[1]/a");
    private final By sizeOptionLocator = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div[3]/div[1]/div[2]/div/div/a[3]/div");
    private final By priceOptionLocator = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div[3]/div[1]/div[2]/ol/li[1]/a");

private final By clearAllFiltersBtnLocator = By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div[2]/a");
    public void addFilters() {
        waits.waitForElementToBePresent(selectStyleLocator);
        actions.click(selectStyleLocator);
        waits.waitForElementToBePresent(styleOptionLocator);
        actions.click(styleOptionLocator);
        waits.waitForElementToBePresent(selectSizeLocator);
        actions.click(selectSizeLocator);
        waits.waitForElementToBePresent(sizeOptionLocator);
        actions.click(sizeOptionLocator);
        waits.waitForElementToBePresent(selectPriceLocator);
        actions.click(selectPriceLocator);
        waits.waitForElementToBePresent(priceOptionLocator);
        actions.click(priceOptionLocator);
    }

    public void clearFilters(){
        waits.waitForElementToBePresent(clearAllFiltersBtnLocator);
        actions.click(clearAllFiltersBtnLocator);
    }
}
