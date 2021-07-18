package com.pinhas.qa;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTrelloTests extends TestBase{


    @Test
    public void loginTest() throws InterruptedException {

        clickOnLoginButton();
        fillLoginForm("dmitriy.konde@gmail.com", "Ddmitriy8805");        // "Ddmitriy8805"
        confirmLogin();

        Assert.assertFalse(isAvatarPresent());

        logOut();
        Assert.assertTrue(checkUserLogged());

    }

}