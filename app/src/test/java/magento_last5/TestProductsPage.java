package magento_last5;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestProductsPage {
    WebDriver chromeDriver = null;
    HomePage homePage;
    BasePage basePage;
    ProductsPage productsPage;

    @BeforeTest(groups = "run-all")
    public void setUp() {
        basePage = new BasePage(chromeDriver);
        chromeDriver = basePage.launchDriver();
        homePage = new HomePage(chromeDriver);
        productsPage = homePage.navigateToProductsPage();
    }
//PsP01
    @Test(priority = 1,groups = "run-all")
    public void shouldTestAddFilters(){
        //Arrange

        //Act
            productsPage.addFilters();
        //Assert
        Assert.assertEquals(chromeDriver.getTitle(),"Jackets - Tops - men");
    }
//PsP02
    @Test(priority = 2,groups = "run-all")
    public void shouldTestClearFilters(){
        //Arrange

        //Act
            productsPage.clearFilters();
        //Assert
        Assert.assertEquals(chromeDriver.getTitle(),"Jackets - Tops - men");

    }
    @AfterTest(groups = "run-all")
    public void tearDownClass() {
        basePage.quiteDriver();
    }
}
