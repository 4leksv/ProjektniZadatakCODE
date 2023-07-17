package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataUtil;

import java.util.HashMap;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider1")
    public void testSuccessfulUserLogin(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(inventoryPage.getTitle(), "Swag Labs");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider2")
    public void testLocketOutUserLogin(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlertText().contains("Epic sadface: Sorry, this user has been locked out."), "Alert text is wrong.");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider3")
    public void testProblemUserLogin(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(inventoryPage.getTitle(), "Swag Labs");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider4")
    public void testPerformanceGlitchUserLogin(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(inventoryPage.getTitle(), "Swag Labs");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider5")
    public void testRandomUserLogin(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlertText().contains("Epic sadface: Username and password do not match any user in this service"), "Alert text is wrong.");
    }

}
    
