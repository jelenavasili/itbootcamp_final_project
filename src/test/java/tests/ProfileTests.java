package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest{
    @Test
    public void editsProfile () {
        homePage.login();
        loginPage.login("admin@admin.com", "12345");
        profilePage.clickMyProfile();

        String name = faker.name().name();
        String phone = faker.phoneNumber().phoneNumber();
        String country = faker.address().country();
        String twitter = "https://" + faker.internet().url();
        String github = "https://" + faker.internet().url();

        profilePage.createProfile(name, phone, country, twitter, github);
        profilePage.saveProfile();

        WebElement message = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"));
        Assert.assertTrue(message.getText().contains("Profile saved successfuly"));

        String expectedResult = name;
        String actualResult = driver.findElement(By.id("name")).getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);

        String expectedResult1 = phone;
        String actualResult1 = driver.findElement(By.id("phone")).getAttribute("value");
        Assert.assertEquals(actualResult1, expectedResult1);

        String expectedResult2 = "Bucaramanga";
        String actualResult2 = driver.findElement(By.id("city")).getAttribute("value");
        Assert.assertEquals(expectedResult2, actualResult2);

        String expectedResult3 = country;
        String actualResult3 = driver.findElement(By.id("country")).getAttribute("value");
        Assert.assertEquals(actualResult3, expectedResult3);

        String expectedResult4 = twitter;
        String actualResult4 = driver.findElement(By.id("urlTwitter")).getAttribute("value");
        Assert.assertEquals(actualResult4, expectedResult4);

        String expectedResult5= github;
        String actualResult5 = driver.findElement(By.id("urlGitHub")).getAttribute("value");
        Assert.assertEquals(actualResult5, expectedResult5);
    }
}
