package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTests extends BaseTest {
    @Test
    public void loginPageVisit() {
        homePage.login();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void login () {
        homePage.login();
        loginPage.login("admin@admin.com", "12345");

        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";  //verify url contins /home route
        driverWait.until(ExpectedConditions.urlMatches("https://vue-demo.daniel-avellaneda.com/home"));
        String actualResult= driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void displaysErrorsWhenUserDoesNotExist() {
        homePage.login();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        loginPage.login(email, password);

        String expectedResult = "User does not exists";
        WebElement actualResult = loginPage.getmsgUserNotExists();
        Assert.assertEquals(actualResult.getText(), expectedResult);

        String expectedResult1 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult1 = driver.getCurrentUrl();
        Assert.assertEquals(expectedResult1, actualResult1);
    }

    @Test
    public void checkInputTypes () {
        homePage.login();
        String expectedResult = "email";
        String actualResult = loginPage.getEmail().getAttribute("type");
        Assert.assertEquals(actualResult, expectedResult);

        String expectedResult1 = "password";
        String actualResult1 = loginPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualResult1, expectedResult1);
    }
    @Test
    public void displaysErrorsWhenPasswordIsWrong() {
        homePage.login();
        loginPage.login("admin@admin.com", "123456");

        String expectedResult = "Wrong password";
        WebElement actualResult = loginPage.getmsgWrongPassword();
        Assert.assertEquals(expectedResult, actualResult.getText());

        String expectedResult1 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult1 = driver.getCurrentUrl();
        Assert.assertEquals(expectedResult1, actualResult1);
    }
    @Test
    public void logout() {
        homePage.login();
        loginPage.login("admin@admin.com", "12345");

        WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span"));
        Assert.assertTrue(logoutBtn.isDisplayed());
        logoutBtn.click();

        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult1 = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(expectedResult1, driver.getCurrentUrl());
        loginPage.getLogoutBtn().click();
    }
    @AfterMethod
    public void afterMethod() {
        List<WebElement> logout = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span"));
        if (logout.size() == 1) {
            logout.get(0).click();
        }
    }
   }

