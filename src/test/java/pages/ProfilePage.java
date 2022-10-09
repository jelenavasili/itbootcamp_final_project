package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    protected By myProfile = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");
    protected By save = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button/span");
    protected By name = By.id("name");
    protected By phone = By.id("phone");
    protected By city = By.id("city");
    protected By country = By.id("country");
    protected By twitter = By.id("urlTwitter");
    protected By github = By.id("urlGitHub");


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
        WebElement nameElement = getName();
        nameElement.click();

        nameElement.sendKeys(Keys.CONTROL + "a");
        nameElement.sendKeys(Keys.DELETE);
        nameElement.sendKeys(name);

        WebElement phoneElement = getPhone();
        phoneElement.click();
        phoneElement.sendKeys(Keys.CONTROL + "a");
        phoneElement.sendKeys(Keys.DELETE);
        phoneElement.sendKeys(phone);

        WebElement countryElement = getCountry();
        countryElement.click();
        countryElement.sendKeys(Keys.CONTROL + "a");
        countryElement.sendKeys(Keys.DELETE);
        countryElement.sendKeys(country);

        WebElement twitterElement = getTwitter();
        twitterElement.click();
        twitterElement.sendKeys(Keys.CONTROL + "a");
        twitterElement.sendKeys(Keys.DELETE);
        twitterElement.sendKeys(twitter);

        WebElement githubElement = getGithub();
        githubElement.click();
        githubElement.sendKeys(Keys.CONTROL + "a");
        githubElement.sendKeys(Keys.DELETE);
        githubElement.sendKeys(github);

    }
}
