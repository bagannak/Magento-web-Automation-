package magento_last5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    PageWaits waits = new PageWaits(driver);
    PageActions actions = new PageActions(driver);
    private final By loginButtonLocator = By.partialLinkText("Sign In");
    private final By productLocator = By.partialLinkText("Radiant Tee");
    private final By searchBarLocator = By.id("search");
    private final By menDropdownLocator = By.xpath("//*/a[@id = 'ui-id-5']");
    private final By topsDropdownLocator = By.xpath("//*/a[@id = 'ui-id-17']");
    private final By jacketsLocator = By.xpath("//*/a[@id = 'ui-id-19']");

    private final By btn = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
    private final By myAccountBtnLocator = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a");

private final By myOrderBtnLocator = By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div[2]/ul/li[2]/a");
    public LoginPage navigateToLoginPage() {
        waits.waitForElementToBePresent(loginButtonLocator);
        actions.click(loginButtonLocator);
        return new LoginPage(driver);
    }

    public void searchForProduct(String name) {
        waits.waitForElementToBePresent(searchBarLocator);
        actions.type(searchBarLocator, name);
        driver.findElement(searchBarLocator).sendKeys(Keys.ENTER);

    }

    public ProductPage navigateToProductPage() {
        waits.waitForElementToBePresent(productLocator);
        actions.click(productLocator);
        return new ProductPage(driver);
    }


    public UserAccountPage navigateToUserAccountPage() {
        waits.waitForElementToBePresent(btn);
        actions.click(btn);
        waits.waitForElementToBePresent(myAccountBtnLocator);
        actions.click(myAccountBtnLocator);
        return new UserAccountPage(driver);
    }

    public ProductsPage navigateToProductsPage() {
        waits.waitForElementToBePresent(menDropdownLocator);
        actions.moveToElement(menDropdownLocator);
        waits.waitForElementToBePresent(topsDropdownLocator);
        actions.moveToElement(topsDropdownLocator);
        waits.waitForElementToBePresent(jacketsLocator);
        actions.click(jacketsLocator);
        return new ProductsPage(driver);
    }


    public OrderPage navigateToOrderPage(){
        navigateToUserAccountPage();
        waits.waitForElementToBePresent(myOrderBtnLocator);
        actions.click(myOrderBtnLocator);
        return new OrderPage(driver);
    }
}
