package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    private By myProfile = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");
    private By save = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button/span");
    private By name = By.id("name");
    private By phone = By.id("phone");
    private By city = By.id("city");
    private By country = By.id("country");
    private By twitter = By.id("urlTwitter");
    private By github = By.id("urlGitHub");
    private By msgSavedSuccessfully = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    WebElement getMyProfile() {
        return getDriver().findElement(myProfile);
    }

    WebElement getSave() {
        return getDriver().findElement(save);
    }

    WebElement getName() {
        return getDriver().findElement(name);
    }

    WebElement getPhone() {
        return getDriver().findElement(phone);
    }

    WebElement getCity() {
        return getDriver().findElement(city);
    }
    WebElement getMsgSavedSuccessfully () {
        return getDriver().findElement(msgSavedSuccessfully);
    }

    WebElement getCountry() {
        return getDriver().findElement(country);
    }

    WebElement getTwitter() {
        return getDriver().findElement(twitter);
    }

    WebElement getGithub() {
        return getDriver().findElement(github);
    }

    public void clickMyProfile() {
        getMyProfile().click();
    }

    public void saveProfile() {
        getSave().click();
    }

    public void createProfile(String name, String phone, String country, String twitter, String github) {

        getName().click();
        getName().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getName().sendKeys(name);

        getPhone().click();
        getPhone().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getPhone().sendKeys(phone);

        getCountry().click();
        getCountry().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getCountry().sendKeys(country);

        getTwitter().click();
        getTwitter().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getTwitter().sendKeys(twitter);

        getGithub().click();
        getGithub().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getGithub().sendKeys(github);
    }
}
