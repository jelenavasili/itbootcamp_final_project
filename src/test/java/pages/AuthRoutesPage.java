package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthRoutesPage extends BasePage{
    protected By home = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[1]/span");


    public AuthRoutesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public WebElement getHome () {
        return getDriver().findElement(home);
    }
    public void homeClick () {
        getHome().click();
    }
}
