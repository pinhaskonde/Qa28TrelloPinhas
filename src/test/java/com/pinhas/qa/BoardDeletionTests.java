package com.pinhas.qa;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        //isAvatarPresent
        if (!isAvatarPresent()) {
            login("fagehe4438@godpeed.com", "dima12345");
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
        int boardsCount = getBoardsCount();
        Thread.sleep(3000);
        while (boardsCount > 1) {
            selectFirstBoard();
            openMenu();
            deleteBoard();
            returnOnHomePage();
            boardsCount = getBoardsCount();
            Thread.sleep(3000);
        }
    }

    public void returnOnHomePage() {
        waitForElement(By.cssSelector("[data-test-id*='header-home-button']"),30);
        click(By.cssSelector("[data-test-id*='header-home-button']"));
    }

    public void deleteBoard() {
        if (!isElementDisplayed(By.cssSelector(".js-open-more"))){
            click(By.cssSelector(".icon-back"));
        }
        click(By.cssSelector(".js-open-more"));
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector(".js-delete"));
        click(By.cssSelector(".js-confirm"));

    }

    public void openMenu() {
        click(By.cssSelector(".js-show-sidebar"));
    }

    public int getBoardsCount() {
        return wd.findElements(
          By.xpath("//*[contains(@class, 'boards-page-board-section-header-icon-default-image')]/../../../..//li")).size()-1;
    }

    public void selectFirstBoard() {
        click(By.xpath("//*[contains(@class, 'boards-page-board-section-header-icon-default-image')]/../../../..//li"));
    }

}
