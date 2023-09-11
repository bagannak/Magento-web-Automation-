package magento_last5;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestWishListPage {
    WebDriver chromeDriver = null;
    HomePage homePage;
    BasePage basePage;
    PageWaits waits;
    WishListPage wishListPage;


    @BeforeTest(groups = "run-all")
    public void setUp() {
        basePage = new BasePage(chromeDriver);
        chromeDriver = basePage.launchDriver();
        homePage = new HomePage(chromeDriver);
        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.logIn();
        waits = new PageWaits(chromeDriver);
        ProductPage productPage = homePage.navigateToProductPage();
        wishListPage = productPage.addProductToWishList();
    }
//WP01
    @Test(groups = "run-all")
    public void shouldEditProductFromWishList() {
        //Arrange

        //Act
        wishListPage.editProductFromWishList();
        //Assert
        Assert.assertEquals(chromeDriver.getTitle(), "My Wish List");
    }
//WP02
    @Test(groups = "run-all")
    public void shouldDeleteProductFromWishList() {
        //Arrange

        //Act
        wishListPage.deleteProductFromWishList();
        //Assert
        Assert.assertEquals(chromeDriver.getTitle(), "My Wish List");

    }
    @AfterTest(groups = "run-all")
    public void tearDownClass() {
        basePage.quiteDriver();
    }
}
