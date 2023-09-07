package magento_last5;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestAutomation {
    @Test
    public void shouldTestSomething() throws InterruptedException {
        //Arrange
        WebDriver chromeDriver = null;
        BasePage basePage = new BasePage(chromeDriver);
        chromeDriver = basePage.launchDriver();
        HomePage homePage = new HomePage(chromeDriver);
        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.logIn();
        Thread.sleep(5000);
        homePage.searchForProduct("Argus All-Weather Tank");
        Thread.sleep(3000);
        homePage.navigateToProductPage();
        Thread.sleep(4000);
        basePage.quiteDriver();
    }
}


