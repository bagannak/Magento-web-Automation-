package magento_last5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressBookPage extends BasePage {
    public AddressBookPage(WebDriver driver) {
        super(driver);
    }

    PageWaits waits = new PageWaits(driver);
    PageActions actions = new PageActions(driver);
    private final By addNewAddressBtnLocator = By.xpath("//*/button[@title = 'Add New Address']");
    private final By firstNameInputLocator = By.cssSelector("#firstname");
    private final By lastNameInputLocator = By.cssSelector("#lastname");
    private final By phoneNumberLocator = By.cssSelector("#telephone");
    private final By streetAddressLine1Locator = By.cssSelector("#street_1");
    private final By cityInputLocator = By.cssSelector("#city");
    private final By zipCodeInputLocator = By.cssSelector("#zip");
    private final By selectStateLocator = By.cssSelector("#region_id");
    private final By selectCountryLocator = By.cssSelector("#country");
    private final By saveBtnLocator = By.xpath("/html/body/div[2]/main/div[2]/div[1]/form/div/div[1]/button");

    private final By deleteBtnLocator = By.xpath("//a[@class = 'action delete' and @role = 'delete-address']");


    public void addNewAddress() {
        waits.waitForElementToBePresent(addNewAddressBtnLocator);
        waits.waitForElementToBeClickable(addNewAddressBtnLocator);
        actions.click(addNewAddressBtnLocator);

        waits.waitForElementToBePresent(firstNameInputLocator);
        actions.type(firstNameInputLocator, "arun");

        waits.waitForElementToBePresent(lastNameInputLocator);
        actions.type(lastNameInputLocator, "kumar");

        waits.waitForElementToBePresent(phoneNumberLocator);
        actions.type(phoneNumberLocator, "8088037763");

        waits.waitForElementToBePresent(streetAddressLine1Locator);
        actions.type(streetAddressLine1Locator, "100ft Road");

        waits.waitForElementToBePresent(cityInputLocator);
        actions.type(cityInputLocator, "Bengaluru");

        waits.waitForElementToBeClickable(selectStateLocator);
        Select selectState = new Select(driver.findElement(selectStateLocator));
        selectState.selectByVisibleText("Kansas");

        waits.waitForElementToBePresent(zipCodeInputLocator);
        actions.type(zipCodeInputLocator, "14526-6457");

        waits.waitForElementToBePresent(selectCountryLocator);
        Select selectCountry = new Select(driver.findElement(selectCountryLocator));
        selectCountry.selectByVisibleText("India");

        waits.waitForElementToBePresent(saveBtnLocator);
        actions.click(saveBtnLocator);
    }

    public void deleteAddress(){
        actions.executeJS("arguments[0].scrollIntoView();",driver.findElement(deleteBtnLocator));
        waits.waitForElementToBePresent(deleteBtnLocator);
        actions.click(deleteBtnLocator);
        Alert alert = waits.waitForAlert();
        alert.accept();
    }
}