package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {
    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated () {
        authRoutesPage.homeClick();
        driver.get("https://vue-demo.daniel-avellaneda.com/home");

        String expectedResult = driver.getCurrentUrl();

        Assert.assertTrue(expectedResult.endsWith("login"));
    }
    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated () {
    driver.get("https://vue-demo.daniel-avellaneda.com/profile");
    String expectedResult = driver.getCurrentUrl();
    Assert.assertTrue(expectedResult.endsWith("login"));
    }

    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated ()  {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");

        String expectedResult = driver.getCurrentUrl();
        Assert.assertTrue(expectedResult.endsWith("login"));
    }
    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated () {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");

        String expectedResult = driver.getCurrentUrl();
        Assert.assertTrue(expectedResult.endsWith("login"));
    }
}
