package magento_last5;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestProductsPage {
    WebDriver chromeDriver = null;
    HomePage homePage;
    BasePage basePage;
    ProductsPage productsPage;

    @BeforeClass(groups = "run-all")
    public void setUp() {
        basePage = new BasePage(chromeDriver);
        chromeDriver = basePage.launchDriver();
        homePage = new HomePage(chromeDriver);
        productsPage = homePage.navigateToProductsPage();
    }

    @Test
    public void shouldTestAddFilters(){
        //Arrange

        //Act
            productsPage.addFilters();
        //Assert
    }

    @Test
    public void shouldTestClearFilters(){
        //Arrange

        //Act
            productsPage.clearFilters();
        //Assert
    }
    @AfterClass
    public void tearDownClass() {
        basePage.quiteDriver();
    }
}
