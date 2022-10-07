package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage{

    protected By myProfile = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");
    protected By save = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button/span");


    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    WebElement getMyProfile () {
        return getDriver().findElement(myProfile);
    }
    WebElement getSave () {
        return getDriver().findElement(save);
    }
    public void clickMyProfile () {
        getMyProfile().click();
    }
    public void saveProfile () {
        getSave().click();
    }
}
