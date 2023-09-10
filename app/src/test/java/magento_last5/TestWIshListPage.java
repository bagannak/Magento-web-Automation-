package magento_last5;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestWIshListPage {
    WebDriver chromeDriver = null;
    HomePage homePage;
    BasePage basePage;
    PageWaits waits;
    WishListPage wishListPage;


    @BeforeClass
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

    @Test
    public void shouldEditProductFromWishList() {
        //Arrange

        //Act
        wishListPage.editProductFromWishList();
        //Assert
        Assert.assertEquals(chromeDriver.getTitle(), "My Wish List");
    }

    @Test
    public void shouldDeleteProductFromWishList() {
        //Arrange

        //Act
        wishListPage.deleteProductFromWishList();
        //Assert
        Assert.assertEquals(chromeDriver.getTitle(), "My Wish List");

    }
    @AfterClass
    public void tearDownClass() {
        basePage.quiteDriver();
    }
}
