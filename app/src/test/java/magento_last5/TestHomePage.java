package magento_last5;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestHomePage {
    WebDriver chromeDriver = null;
    HomePage homePage;
    BasePage basePage;
    WishListPage wishListPage;


    @BeforeTest(groups = "run-all")
    public void setUp() {
        basePage = new BasePage(chromeDriver);
        chromeDriver = basePage.launchDriver();
        homePage = new HomePage(chromeDriver);
    }
//HP01
    @Test(priority = 1, groups = "run-all")
    public void shouldTestSearchForProduct() {
        //Act
        homePage.searchForProduct("Argus All-Weather Tank");
        //Assert
        Assert.assertEquals(chromeDriver.getTitle(),"Search results for: 'Argus All-Weather Tank'");

    }
//HP02
    @Test(priority = 2, groups = "run-all")
    public void shouldNavigateToProductPage() {
        //Arrange
        String title;
        //Act
        chromeDriver.navigate().back();
        homePage.navigateToProductPage();
        title = chromeDriver.getTitle();
        //Assert
        Assert.assertEquals(title, "Radiant Tee");
    }
//HP03
    @Test(priority = 3,groups = {"run-all"})
    public void shouldTestNavigateToProductsPage() {
        //Arrange
        String title;
        //Act
        homePage.navigateToProductsPage();
        title = chromeDriver.getTitle();
        //Assert
        Assert.assertEquals(title, "Jackets - Tops - Men");
    }
    //HP04
    @Test(priority = 4, groups = "run-all")
    public void shouldTestNavigateToUserAccountPage() {
        //Arrange
        String title;
        LoginPage loginPage = homePage.navigateToLoginPage();
        //Act
        loginPage.logIn();
        homePage.navigateToUserAccountPage();
        title = chromeDriver.getTitle();
        loginPage.logOut();
        //Assert
        Assert.assertEquals(title, "My Account");

    }

//HP05
    @Test( priority = 5,groups = "run-all1")
    public void shouldTestNavigateToOrderPage(){
        //Arrange
        String title;
        LoginPage loginPage = homePage.navigateToLoginPage();
        //Act
        loginPage.logIn();
        homePage.navigateToOrderPage();
        title = chromeDriver.getTitle();
        loginPage.logOut();
        //Assert
        Assert.assertEquals(title,"My Orders");
    }

    @AfterTest(groups = "run-all")
    public void tearDownClass() {

        basePage.quiteDriver();
    }
}


