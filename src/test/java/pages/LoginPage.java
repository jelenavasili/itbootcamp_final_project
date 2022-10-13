package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By email = By.id("email");
    private By password = By.id("password");
    private By loginBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span");
    //private By myProfile = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]/span");
    private By msgUserNotExists = By. xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private By msgWrongPassword = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private By logoutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");

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
    public WebElement getLogoutBtn() {
        return getDriver().findElement(logoutBtn);
    }
    public  WebElement getmsgUserNotExists () {
        return getDriver().findElement(msgUserNotExists);
    }
    public WebElement getmsgWrongPassword () {
        return getDriver().findElement(msgWrongPassword);
    }
    public void login (String email, String password) {
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLoginBtn().click();
    }
  }