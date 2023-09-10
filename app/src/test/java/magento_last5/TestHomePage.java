package magento_last5;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestHomePage {
    WebDriver chromeDriver = null;
    HomePage homePage;
    BasePage basePage;

    @BeforeClass(groups = "run-all")
    public void setUp() {
        basePage = new BasePage(chromeDriver);
        chromeDriver = basePage.launchDriver();
        homePage = new HomePage(chromeDriver);
    }

    @Test(priority = 1, groups = "run-all")
    public void shouldTestSearchForProduct() {
        //Act
        homePage.searchForProduct("Argus All-Weather Tank");

        //Assert

    }

    @Test(priority = 2, groups = "run-all")
    public void shouldNavigateToProductPage() {
        //Arrange
        String title;
        //Act
        homePage.navigateToProductPage();
        title = chromeDriver.getTitle();
        //Assert
        Assert.assertEquals(title, "Radiant Tee");
    }

    @Test(priority = 3, groups = "run-all")
    public void shouldTestNavigateToUserAccountPage() {
        //Arrange
        String title;
        LoginPage loginPage = homePage.navigateToLoginPage();
        //Act
        loginPage.logIn();
        homePage.navigateToUserAccountPage();
        title = chromeDriver.getTitle();

        //Assert
        Assert.assertEquals(title, "My Account");

    }

    @AfterClass
    public void tearDownClass() {

        basePage.quiteDriver();
    }
}


