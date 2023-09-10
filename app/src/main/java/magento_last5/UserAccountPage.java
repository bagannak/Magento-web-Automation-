package magento_last5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAccountPage extends BasePage {
    PageWaits waits = new PageWaits(driver);
    PageActions actions = new PageActions(driver);

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    private final By editUserInfo = By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[3]/div[2]/div/div[2]/a[1]");
    private final By firstNameInputLocator = By.cssSelector("#firstname");
    private final By lastNameInputLocator = By.cssSelector("#lastname");
    private final By saveChangesBtnLocator = By.xpath("/html/body/div[2]/main/div[2]/div[1]/form/div/div[1]/button");
    private final By manageAddressLocator = By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[4]/div[1]/a");

    public void editUserInfo() {
        waits.waitForElementToBePresent(editUserInfo);
        actions.click(editUserInfo);
        waits.waitForElementToBePresent(firstNameInputLocator);
        actions.type(firstNameInputLocator, "Arun");
        waits.waitForElementToBePresent(lastNameInputLocator);
        actions.type(lastNameInputLocator, "Kumar");
        waits.waitForElementToBePresent(saveChangesBtnLocator);
        actions.click(saveChangesBtnLocator);
    }

    public AddressBookPage navigateToAddressBookPage(){
        waits.waitForElementToBePresent(manageAddressLocator);
        actions.click(manageAddressLocator);
        return new AddressBookPage(driver);
    }
}
