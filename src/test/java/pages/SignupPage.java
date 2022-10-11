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
    private By msgEmailAlereadyExists = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li");
    private By msgIMPORTANT = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");
    private By closeButtonIMPORTANT = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button/span");

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
    public WebElement msgEmailAlreadyExists () {
        return getDriver().findElement(msgEmailAlereadyExists);
    }
    public WebElement msgIMPORTANT () {
        return  getDriver().findElement(msgIMPORTANT);
    }
    public WebElement closeButtonIMPORTANT () {
        return getDriver().findElement(closeButtonIMPORTANT);
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
