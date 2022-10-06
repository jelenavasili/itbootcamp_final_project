package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPage extends BasePage {

    private By email = By.id("email");
    private By password = By.id("password");
    private By loginBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span");


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }


    public void login (String email, String password) {
        WebElement emailElement = getEmail();
        emailElement.sendKeys(email);

        WebElement passwordElement = getPassword();
        passwordElement.sendKeys(password);

        WebElement loginElement = getLoginBtn();
        loginElement.click();
    }

}
