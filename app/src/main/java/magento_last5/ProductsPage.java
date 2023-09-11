package magento_last5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    PageWaits waits = new PageWaits(driver);
    PageActions actions = new PageActions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    private final By styleOptionLocator = By.xpath("(//div[@id='narrow-by-list']/div)/div[2]/ol/li[1]/a");
    private final By sizeOptionLocator = By.xpath("(//div[@id='narrow-by-list']/div)/div[2]/div[1]/div/a[@aria-label = 'M']");
    private final By priceOptionLocator = By.xpath("(//div[@id='narrow-by-list']/div)/div[2]/ol/li[2]/a");
List<WebElement> listOfOption = new ArrayList<>(driver.findElements(By.xpath("(//div[@id='narrow-by-list']/div)")));

private final By clearAllFiltersBtnLocator = By.xpath("//a[@class = 'action clear filter-clear']");
    public void addFilters() {
        for (WebElement element : listOfOption) {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            break;
        }
        waits.waitForElementToBePresent(styleOptionLocator);
        actions.click(styleOptionLocator);

    }

    public void clearFilters(){
        waits.waitForElementToBePresent(clearAllFiltersBtnLocator);
        actions.click(clearAllFiltersBtnLocator);
    }
}
