package magento_last5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAddressBookPage {
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

    @Test(priority = 1)
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

    @Test(priority = 2)
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

    @AfterClass
    public void tearDownClass() {
        basePage.quiteDriver();
    }
}
