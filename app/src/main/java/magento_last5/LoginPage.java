package magento_last5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    PageWaits waits = new PageWaits(driver);
    PageActions actions = new PageActions(driver);
    private final By emailInputLocator = By.id("email");
    private final By passwordInputLocator = By.id("pass");
    private final By signInBtnLocator = By.id("send2");
    private final By dropDownBtnLocator = By.xpath("//span[@class='customer-name']/button[@class ='action switch']");
    private final By signOutBtnLocator = By.partialLinkText("Sign Out");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage logIn() {
        waits.waitForElementToBePresent(emailInputLocator);
        actions.type(emailInputLocator, "bagannak@testvagrant.com");
        actions.type(passwordInputLocator, "Baganna$321");
        actions.click(signInBtnLocator);
        return new HomePage(driver);

    }

    public HomePage logOut() {
        waits.waitForElementToBePresent(dropDownBtnLocator);
        actions.click(dropDownBtnLocator);
        waits.waitForElementToBePresent(signOutBtnLocator);
        actions.click(signOutBtnLocator);
        return new HomePage(driver);
    }

}
