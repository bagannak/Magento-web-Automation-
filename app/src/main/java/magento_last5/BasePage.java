package magento_last5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver launchDriver() {
        if (driver==null)
            driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        return driver;
    }
    public void quiteDriver() {
        if(driver!=null)
            driver.quit();
    }

}
