package magento_last5;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestOrderPage {
    WebDriver chromeDriver = null;
    HomePage homePage;
    BasePage basePage;
    PageWaits waits;
    OrderPage orderPage;

    @BeforeTest(groups = {"run-all","sanity"})
    public void setUp() {
        basePage = new BasePage(chromeDriver);
        chromeDriver = basePage.launchDriver();
        homePage = new HomePage(chromeDriver);
        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.logIn();
        waits = new PageWaits(chromeDriver);
        orderPage = homePage.navigateToOrderPage();
    }
//OP01
    @Test(groups = {"run-all","sanity"})
    public void shouldTestViewOrderDetails() {
        //Arrange
        String title;
        //Act
        orderPage.viewOrderDetails();
        title = chromeDriver.getTitle();
        //Assert
        Assert.assertEquals(title,"Order # 000021722");
    }
    @AfterTest(groups = "run-all")
    public void tearDownClass() {
        basePage.quiteDriver();
    }

}
