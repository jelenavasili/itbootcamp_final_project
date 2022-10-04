package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private Faker faker;
    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeClass
    public void beforeClass () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.get("https://vue-demo.daniel-avellaneda.com/");
        loginPage = new LoginPage(driver, driverWait);
    }
    @Test
    public void login () {
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
        loginPage.login("admin@admin.com", "12345");
        //String expectedResult =
    }
    @Test
    public void displaysErrorsWhenUserDoesNotExist() {
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        loginPage.login(email, password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String expectedResult = "User does not exists";
        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        Assert.assertEquals(actualResult.getText(), expectedResult);

    }

    @Test
    public void loginPageVisit() {
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void checkInputTypes () {
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
        String expectedResult = "email";
        String actualResult = loginPage.getEmail().getAttribute("type");
        Assert.assertEquals(actualResult, expectedResult);

        String expectedResult1 = "password";
        String actualResult1 = loginPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualResult1, expectedResult1);
    }








}





