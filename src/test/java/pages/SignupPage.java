package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {
    private By name = By.id("name");
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");


    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getName () {
        return getDriver().findElement(name);
    }
    public WebElement getEmail () {
        return getDriver().findElement(email);
    }
    public WebElement getPassword () {
        return getDriver().findElement(password);
    }
    public WebElement getConfirmPassword () {
        return getDriver().findElement(confirmPassword);
    }
}
