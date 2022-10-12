package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LocaleTests extends BaseTest{
    @Test
    public void setLocaleToES () {
        localePage.clickLocale();
        WebElement es = driver.findElement(By.id("list-item-75"));
        es.click();
        WebElement headingEs = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        String expectedResult = "Página de aterrizaje";
        Assert.assertEquals(headingEs.getText(), expectedResult);
    }
    @Test
    public void setLocaleToEN () {
        localePage.clickLocale();
        WebElement headingEn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        String expectedResult = "Landing";
        Assert.assertEquals(headingEn.getText(), expectedResult);
    }
    @Test
    public void setLocaleToFR() {
        localePage.clickLocale();
        WebElement fr = driver.findElement(By.id("list-item-77"));
        fr.click();
        WebElement headingFr = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        String expectedResult = "Page d'atterrissage";
        Assert.assertEquals(headingFr.getText(), expectedResult);
    }
}

