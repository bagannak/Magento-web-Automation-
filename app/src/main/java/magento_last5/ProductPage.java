package magento_last5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    PageWaits waits = new PageWaits(driver);
    PageActions actions = new PageActions(driver);
    private final By productLocator = By.partialLinkText("Radiant Tee");

    private final By wishListBtnLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[5]/div/a[1]");
    private final By sizeSelectBtnLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div/div[3]");
    private final By colorSelectBtnLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/div/div");
    private final By qtyInputLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[2]/div/div/div[1]/div/input");
    private final By addAllToCartBtnLocator = By.xpath("/html/body/div[2]/main/div[2]/div[1]/form/div[2]/div[1]/button[3]");
    private final By addToCartBtnLocator = By.cssSelector("div.product-item-inner > div.box-tocart > fieldset > div.product-item-actions > div > button");
    private final By addToCartBtnLocator2 = By.id("product-addtocart-button");

    public WishListPage addProductToWishList() {
        waits.waitForElementToBePresent(wishListBtnLocator);
        actions.click(wishListBtnLocator);
        return new WishListPage(driver);
    }

    public void addProductToCart() {
        actions.executeJS("arguments[0].scrollIntoView();",driver.findElement(addAllToCartBtnLocator));

        waits.waitForElementToBePresent(productLocator);
        actions.moveToElement(productLocator);
        actions.click(productLocator);
        waits.waitForElementToBePresent(addToCartBtnLocator);
        waits.waitForElementToBeClickable(addToCartBtnLocator);
        actions.click(addToCartBtnLocator);
        waits.waitForElementToBePresent(sizeSelectBtnLocator);
        actions.click(sizeSelectBtnLocator);

        waits.waitForElementToBePresent(colorSelectBtnLocator);
        actions.click(colorSelectBtnLocator);

        waits.waitForElementToBePresent(qtyInputLocator);
        actions.type(qtyInputLocator, "3");

        waits.waitForElementToBePresent(addToCartBtnLocator2);
        actions.click(addToCartBtnLocator2);

    }
}
