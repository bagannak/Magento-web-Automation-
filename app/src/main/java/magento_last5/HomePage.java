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
    private final By searchBarLocator= By.id("search");

    public LoginPage navigateToLoginPage(){
        waits.waitForElementToBePresent(loginButtonLocator);
        actions.click(loginButtonLocator);
        return new LoginPage(driver);
    }

    public void searchForProduct(String name){
        waits.waitForElementToBePresent(searchBarLocator);
        actions.type(searchBarLocator,name);
        actions.type(searchBarLocator, String.valueOf(Keys.ENTER));

    }

    public ProductPage navigateToProductPage(){
        actions.click(productLocator);
        return new ProductPage(driver);
    }
}
