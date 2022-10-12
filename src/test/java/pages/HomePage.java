package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    private By login = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span");

    private By signup = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public WebElement getLoginBtn() {
        return getDriver().findElement(login);
    }

    public WebElement getSignup() {
        return getDriver().findElement(signup);
    }

    public void login () {
    getLoginBtn().click();

    }
    public void openSignupPage() {
        getSignup().click();
    }
}
