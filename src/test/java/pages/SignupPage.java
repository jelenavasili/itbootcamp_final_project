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
    private By signupBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span");

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
    public WebElement getSignUpBtn () {
        return getDriver().findElement(signupBtn);
    }

    public void signup(String name, String email, String password, String confirmPassword) {
    WebElement nameElement = getName();
    nameElement.sendKeys(name);

    WebElement emailElement = getEmail();
    emailElement.sendKeys(email);

    WebElement passwordElement = getPassword();
    passwordElement.sendKeys(password);

    WebElement confirmPasswordElement = getConfirmPassword();
    confirmPasswordElement.sendKeys(confirmPassword);

    WebElement signupBtnElement = getSignUpBtn();
    signupBtnElement.click();
    }
}
