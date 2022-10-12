package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.List;

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
        adminCitiesPage.newItem(faker.address().city());

        WebElement actualResult = adminCitiesPage.getMsgSavedSuccessfully();
        Assert.assertTrue(actualResult.getText().contains("Saved successfully"));
    }
    @Test
    public void editCity() {
        homePage.login();
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.editCity(faker.address().city());

        WebElement message = adminCitiesPage.getMsgSavedSuccessfully();
        Assert.assertTrue(message.getText().contains("Saved successfully"));
    }
    @Test
    public void searchCity() {
        homePage.login();
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.editCity(faker.address().city());

        WebElement search = adminCitiesPage.getSearchField();
        search.clear();

        WebElement city = adminCitiesPage.getSearchedCity();
        search.sendKeys(city.getText());
        Assert.assertTrue(city.isDisplayed());
    }
    @Test
    public void deleteCity() {
        homePage.login();
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();

        WebElement city = adminCitiesPage.getSearchedCity();
        WebElement search = adminCitiesPage.getSearchField();
        search.clear();
        search.sendKeys(city.getText());

        WebElement delete = adminCitiesPage.getDeleteCity();
        delete.click();

        WebElement deleteDialog = adminCitiesPage.getDeleteDialog();
        deleteDialog.click();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        WebElement message = adminCitiesPage.getMsgDeletedSuccessfully();
        Assert.assertTrue(message.getText().contains("Deleted successfully"));
    }
    @AfterMethod
    public void afterMethod() {
        List<WebElement> logout = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span"));
        if (logout.size() == 1) {
            logout.get(0).click();
        }
    }
}

