package magento_last5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {

    public OrderPage(WebDriver driver) {
        super(driver);
    }
    PageWaits waits = new PageWaits(driver);
    PageActions actions = new PageActions(driver);
    private final By viewOrderBtnLocator = By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[6]/a[1]");

    public void viewOrderDetails(){
        waits.waitForElementToBePresent(viewOrderBtnLocator);
        actions.click(viewOrderBtnLocator);
    }
}
