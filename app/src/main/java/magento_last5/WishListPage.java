package magento_last5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    PageActions actions = new PageActions(driver);
    PageWaits waits = new PageWaits(driver);
    private final By productLocator = By.partialLinkText("Radiant Tee");
    private final By deleteProductBtnLocator = By.xpath("//div[@class='product-item-inner']//div[@class='product-item-actions']//a[@class='btn-remove action delete']");
    private final By editProductBtnLocator = By.xpath("//form//*[@class='product-item-actions']/a[1]");
    private final By sizeSelectBtnLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div/div[3]");
    private final By colorSelectBtnLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/div/div");
    private final By qtyInputLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[2]/div/div/div[1]/div/input");
    private final By updateWishListBtnLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[5]/div/a[1]");

    private final By addAllToCartBtnLocator = By.xpath("/html/body/div[2]/main/div[2]/div[1]/form/div[2]/div[1]/button[3]");
    public void deleteProductFromWishList() {
        actions.executeJS("arguments[0].scrollIntoView();",driver.findElement(addAllToCartBtnLocator));
        waits.waitForElementToBePresent(productLocator);

        actions.moveToElement(productLocator);
        waits.waitForElementToBePresent(deleteProductBtnLocator);
        actions.moveToElement(deleteProductBtnLocator);
        waits.waitForElementToBeClickable(deleteProductBtnLocator);
        actions.click(deleteProductBtnLocator);
    }

    public void editProductFromWishList() {
        actions.executeJS("arguments[0].scrollIntoView();",driver.findElement(addAllToCartBtnLocator));
        waits.waitForElementToBePresent(productLocator);
        actions.moveToElement(productLocator);
        waits.waitForElementToBePresent(editProductBtnLocator);
        actions.moveToElement(editProductBtnLocator);
        waits.waitForElementToBeClickable(editProductBtnLocator);
        actions.click(editProductBtnLocator);


        waits.waitForElementToBePresent(sizeSelectBtnLocator);
        actions.click(sizeSelectBtnLocator);

        waits.waitForElementToBePresent(colorSelectBtnLocator);
        actions.click(colorSelectBtnLocator);

        waits.waitForElementToBePresent(qtyInputLocator);
        actions.type(qtyInputLocator, "3");

        waits.waitForElementToBePresent(updateWishListBtnLocator);
        actions.click(updateWishListBtnLocator);
    }


}
