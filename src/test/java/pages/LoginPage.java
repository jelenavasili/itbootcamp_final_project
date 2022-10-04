package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPage extends BasePage {

    private By url = By.linkText("https://vue-demo.daniel-avellaneda.com/login");
    private By email = By.id("email");
    private By password = By.id("password");
    private By loginBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span");


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getUrl() {
        return getDriver().findElement(url);
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



//        if(getUrl().isDisplayed()){
//           return true;
//        } else {
//            return false;
//        }


    //Test #2: Checks input types
    //assert:
    //•	Verifikovati da polje za unos emaila za atribut type ima vrednost email
    //•	Verifikovati da polje za unos lozinke za atribut type ima vrednost password

//
//
//    String actualReseut =
//    }


    public void login (String email, String password) {
        WebElement emailElement = getEmail();
        emailElement.sendKeys(email);

        WebElement passwordElement = getPassword();
        passwordElement.sendKeys(password);

        WebElement loginElement = getLoginBtn();
        loginElement.click();
    }

}
