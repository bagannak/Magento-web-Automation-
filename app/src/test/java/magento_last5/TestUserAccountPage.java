package magento_last5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestUserAccountPage {
    WebDriver chromeDriver = null;
    HomePage homePage;
    BasePage basePage;
    PageWaits waits;
    UserAccountPage userAccountPage;
    LoginPage loginPage;


    @BeforeTest(groups = "run-all")
    public void setUp() {
        basePage = new BasePage(chromeDriver);
        chromeDriver = basePage.launchDriver();
        homePage = new HomePage(chromeDriver);
        loginPage = homePage.navigateToLoginPage();
        loginPage.logIn();
        waits = new PageWaits(chromeDriver);
        userAccountPage = homePage.navigateToUserAccountPage();
    }
//UAP01
    @Test(groups = "run-all")
    public void shouldTestEditUserInfo(){
        //Arrange
        By successMassageLocator = By.xpath("//div[@role='alert']/div/div");
        //Act
        userAccountPage.editUserInfo();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMassageLocator));
        WebElement messageEle = chromeDriver.findElement(successMassageLocator);
        String message = messageEle.getText();

        //Assert
        Assert.assertEquals(message, "You saved the account information.");
    }
    //UAP02
    @Test(groups = "run-all")
    public void shouldTestNavigateToAddressBookPage(){
        //Arrange
        String title;
        //Act
            userAccountPage.navigateToAddressBookPage();
            title = chromeDriver.getTitle();
        //Assert
        Assert.assertEquals(title,"Address Book");
    }
    @AfterTest(groups = "run-all")
    public void tearDownClass() {
        basePage.quiteDriver();
    }
}
