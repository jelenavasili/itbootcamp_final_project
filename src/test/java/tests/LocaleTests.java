package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{
    @Test
    public void setLocaleToES () {
        localePage.clickLocale();

        WebElement es = driver.findElement(By.id("list-item-75"));
        es.click();
        String expectedResult = "Página de aterrizaje";
        Assert.assertTrue(expectedResult.contains("Página de aterrizaje"));
    }

    @Test
    public void setLocaleToEN () {
        localePage.clickLocale();

        WebElement en = driver.findElement(By.id("list-item-73"));
        en.click();
        String expectedResult = "Landing";
        Assert.assertTrue(expectedResult.contains("Landing"));
    }
    @Test
    public void setLocaleToFR() {
        localePage.clickLocale();

        WebElement fr = driver.findElement(By.id("list-item-77"));
        fr.click();
        String expectedResult = "Page d'atterrissage";
        Assert.assertTrue(expectedResult.contains("Page d'atterrissage"));
    }
}

