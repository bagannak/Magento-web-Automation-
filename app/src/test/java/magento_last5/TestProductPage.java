package magento_last5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestProductPage {
    WebDriver chromeDriver = null;
    HomePage homePage;
    BasePage basePage;
    PageWaits waits;
    WishListPage wishListPage;
    ProductPage productPage;

    @BeforeClass
    public void setUp() {
        basePage = new BasePage(chromeDriver);
        chromeDriver = basePage.launchDriver();
        homePage = new HomePage(chromeDriver);
        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.logIn();
        waits = new PageWaits(chromeDriver);
    }

    @Test(priority = 1, groups = "run-all")
    public void shouldTestAddProductToWishList() {
        //Arrange
         productPage = homePage.navigateToProductPage();

        //Act
        wishListPage = productPage.addProductToWishList();

        //Assert
        Assert.assertEquals(chromeDriver.getTitle(), "My Wish List");
    }


@Test(priority = 2, groups = "run-all")
public void shouldTestAddProductToCart(){
    //Arrange
By countLocator = By.xpath("//*[@class = 'counter-number']");
    //Act
        productPage.addProductToCart();
        waits.waitForElementToBePresent(countLocator);
    //Assert
    Assert.assertEquals(chromeDriver.findElement(countLocator).getText(), "18");

}
    @AfterClass
    public void tearDownClass() {
        basePage.quiteDriver();
    }
}
