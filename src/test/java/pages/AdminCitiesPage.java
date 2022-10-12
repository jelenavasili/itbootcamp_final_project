package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {
    private By admin = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    private By cities = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");
    private By newItem = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span");
    private By name = By.id("name");
    private By save = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]/span");
    private By logout = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span");
    private By editCity = By.id("edit");
    private By msgSavedSuccessfully = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By searchedCity = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");
    private By deleteCity = By.xpath("//*[@id=\"delete\"]/span");
    private By deleteDialog = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]/span");
    private By msgDeletesSuccessfully = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By searchField = By.id("search");


    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getAdmin() {
       return getDriver().findElement(admin);
    }
    public WebElement getCities() {
        return getDriver().findElement(cities);
    }
    public WebElement getNewItem() {
        return getDriver().findElement(newItem);
    }
    public WebElement getName() {
        return getDriver().findElement(name);
    }
    public WebElement getSave() {
        return getDriver().findElement(save);
    }
    public WebElement getLogout() {
        return getDriver().findElement(logout);
    }
    public WebElement getEditCity() {
        return getDriver().findElement(editCity);
    }
    public WebElement getMsgSavedSuccessfully () {
        return getDriver().findElement(msgSavedSuccessfully);
    }
    public WebElement getSearchedCity() {
        return getDriver().findElement(searchedCity);
    }
    public WebElement getDeleteCity () {
        return getDriver().findElement(deleteCity);
    }
    public WebElement getDeleteDialog () {
        return getDriver().findElement(deleteDialog);
    }
    public WebElement getMsgDeletedSuccessfully () {
        return getDriver().findElement(msgDeletesSuccessfully);
    }
    public WebElement getSearchField () {
        return getDriver().findElement(searchField);
    }
    public void adminClick () {
        getAdmin().click();
    }
    public void cities() {
        getCities().click();
    }
public void newItem(String city) {
        getNewItem().click();
        getName().sendKeys(city);
        getSave().click();
    }
    public void editCity(String city) {
        getEditCity().click();
        getName().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getName().sendKeys(city);
        getSave().click();
    }
}
