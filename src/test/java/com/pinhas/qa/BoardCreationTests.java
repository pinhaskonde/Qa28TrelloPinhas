package com.pinhas.qa;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        //isAvatarPresent
        if (!isAvatarPresent()) {
            login("fagehe4438@godpeed.com", "dima12345");
        }
    }

    @Test
    public void boardCreationTest() {
        String boardName = "qa28Board_" + System.currentTimeMillis();

        clickOnPlusButton();
        selectCreateBord();
        fillBordCreation(boardName);
        confirmBoardCreation();
        waitForAddListButtonInTheBord();
        String title = getTitle();
        Assert.assertEquals(title, boardName);
    }



}