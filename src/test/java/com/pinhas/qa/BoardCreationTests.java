package com.pinhas.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        //isAvatarPresent
        if (!isElementPresent(By.xpath("//*[@data-test-id='header-member-menu-button']"))) {
            login();
        }
    }

    @Test
    public void boardCreationTest() {
        String boardName = "qa28Board_" + System.currentTimeMillis();
        //click on plus button
        click(By.xpath("//*[@data-test-id='header-create-menu-button']"));
        //selectCreateBord
        click(By.xpath("//*[@data-test-id='header-create-board-button']"));
        //FillBoardCreationForm
        type(By.xpath("//*[@data-test-id='create-board-title-input']"), boardName);
        click(By.xpath("//*[@data-test-id='create-board-submit-button']"));
        String title = wd.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(title, boardName);
    }

}