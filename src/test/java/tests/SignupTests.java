package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SignupPage;

import java.time.Duration;

public class SignupTests {
    private WebDriver driver;
    private WebDriverWait driverWait;
    protected SignupPage signupPage;



    @BeforeClass
    public void beforeClass () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com/signup");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        signupPage = new SignupPage(driver, driverWait);
    }

    @Test
    public void visitSignupPage () {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkInputTypes () {
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
}
