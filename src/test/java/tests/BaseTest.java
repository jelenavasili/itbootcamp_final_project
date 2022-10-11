package tests;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;
import java.time.Duration;

public class BaseTest {
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected Faker faker;
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected SignupPage signupPage;
    protected AdminCitiesPage adminCitiesPage;
    protected AuthRoutesPage authRoutesPage;
    protected LocalePage localePage;
    protected ProfilePage profilePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
        authRoutesPage = new AuthRoutesPage(driver, driverWait);
        localePage = new LocalePage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
        faker = new Faker();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com");
    }
    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}







