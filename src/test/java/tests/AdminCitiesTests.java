package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {

    @Test
    public void visitAdminCitiesPageAndListCities() {
        homePage.login();
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();

        String expectedResult = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        Assert.assertTrue(adminCitiesPage.getLogout().isDisplayed());
    }
    @Test
    public void  createNewCity() {
        homePage.login();
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.newItem();

        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));

        Assert.assertTrue(actualResult.getText().contains("Saved successfully"));
    }

    @Test
    public void editCity() {
        homePage.login();
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.editCity();

        WebElement message = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));

        Assert.assertTrue(message.getText().contains("Saved successfully"));

    }
    @Test
    public void searchCity() {
        homePage.login();
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
    }


}

