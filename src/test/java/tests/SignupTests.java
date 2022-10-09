package tests;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {

    @Test (priority = 0)
    public void visitSignupPage () {
        homePage.openSignupPage();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test (priority = 1)
    public void checkInputTypes () {
        homePage.openSignupPage();
        String expectedResult = "text";
        String actualResult = signupPage.getName().getAttribute("type");
        Assert.assertEquals(actualResult, expectedResult);

        String expectedResult1 = "email";
        String actualResult1 = signupPage.getEmail().getAttribute("type");
        Assert.assertEquals(actualResult1, expectedResult1);

        String expectedResult2 = "password";
        String actualResult2 = signupPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualResult2, expectedResult2);

        String expectedResult3 = "password";
        String actualResult3 = signupPage.getConfirmPassword().getAttribute("type");
        Assert.assertEquals(actualResult3, expectedResult3);
    }

    @Test (priority = 1)
    public void displayErrorsWhenUserAlreadyExists() {
        homePage.openSignupPage();
        signupPage.signup("Test Test", "admin@admin.com", "123654", "123654");
        String expectedResult = "E-mail already exists";
        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"));
        Assert.assertEquals(expectedResult, actualResult.getText());

        String expectedResult1 = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualResult1 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult1, expectedResult1);
    }

    @Test (priority = 1)
    public void signUp() {
        homePage.openSignupPage();
        String name = faker.name().name();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String confirmPassword = password;

        signupPage.signup(name, email, password, confirmPassword);

        driverWait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account" ));
        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"));
        String expectedResult = "IMPORTANT: Verify your account";
        Assert.assertEquals(actualResult.getText(), expectedResult);

    }


}
