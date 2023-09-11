package magento_last5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAddressBookPage {
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
//ABP01
    @Test(priority = 1,groups = "run-all")
    public void shouldTestAddNewAddress() throws InterruptedException {
        //Arrange

        //Act
        AddressBookPage addressBookPage = userAccountPage.navigateToAddressBookPage();
        addressBookPage.addNewAddress();
        Thread.sleep(3000);
        waits.waitForElementToBePresent(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div"));
        String mes = chromeDriver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")).getText();
        //Assert
        Assert.assertEquals(mes,"You saved the address.");
    }
//ABP02
    @Test(priority = 2,groups = "run-all")
    public void shouldTestDeleteAddress(){
        //Arrange

        //Act
        AddressBookPage addressBookPage = userAccountPage.navigateToAddressBookPage();
        addressBookPage.deleteAddress();
        waits.waitForElementToBePresent(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div"));
        String mes = chromeDriver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")).getText();
        //Assert
        Assert.assertEquals(mes,"You deleted the address.");
    }

    @AfterTest(groups = "run-all")
    public void tearDownClass() {
        basePage.quiteDriver();
    }
}
