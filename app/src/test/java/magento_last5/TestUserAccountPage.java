package magento_last5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUserAccountPage {
    WebDriver chromeDriver = null;
    HomePage homePage;
    BasePage basePage;
    PageWaits waits;
    UserAccountPage userAccountPage;
    LoginPage loginPage;


    @BeforeClass
    public void setUp() {
        basePage = new BasePage(chromeDriver);
        chromeDriver = basePage.launchDriver();
        homePage = new HomePage(chromeDriver);
        loginPage = homePage.navigateToLoginPage();
        loginPage.logIn();
        waits = new PageWaits(chromeDriver);
        userAccountPage = homePage.navigateToUserAccountPage();
    }

    @Test
    public void shouldTestEditUserInfo() {
        //Arrange
        By successMassageLocator = By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div");
        //Act
        userAccountPage.editUserInfo();
        waits.waitForElementToBePresent(successMassageLocator);
        WebElement messageEle = chromeDriver.findElement(successMassageLocator);
        String message = messageEle.getText();

        //Assert
        Assert.assertEquals(message, "You saved the account information.");
    }

    @AfterClass
    public void tearDownClass() {
        basePage.quiteDriver();
    }
}
