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
    @BeforeClass
    public void setUp(){
        basePage = new BasePage(chromeDriver);
        chromeDriver = basePage.launchDriver();
        homePage = new HomePage(chromeDriver);
    }
    @Test(priority = 1)
    public void shouldTestSearchForProduct(){
        //Act
        homePage.searchForProduct("Argus All-Weather Tank");

        //Assert

    }

    @Test(priority = 2)
    public void shouldNavigateToProductPage(){
        //Act
            homePage.navigateToProductPage();
        //Assert
        Assert.assertEquals(chromeDriver.getTitle(),"Radiant Tee");
    }
    @AfterClass
    public void tearDownClass(){
        basePage.quiteDriver();
    }
}


