package tests;

import org.testng.annotations.Test;

public class ProfileTests extends BaseTest{
    @Test
    public void editsProfile () {
        homePage.login();
        loginPage.login("admin@admin.com", "12345");
        profilePage.clickMyProfile();
    }
}
