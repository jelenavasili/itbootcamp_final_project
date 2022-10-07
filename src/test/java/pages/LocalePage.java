package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalePage extends BasePage{
    private By languages = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button");

    public LocalePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    WebElement getLanguages () {
       return getDriver().findElement(languages);
    }

public void clickLocale () {
    getLanguages().click();
}
}
