package com.pinhas.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTrelloTests extends TestBase{

    @Test
    public void loginTest() throws InterruptedException {
        //Click on login button
//      wd.findElement(By.xpath("//a[@href='/login']")).click();
        click(By.xpath("//a[@href='/login']"));

//      fillLoginForm
//      wd.findElement(By.xpath("//input[@id='user']")).click();
//      wd.findElement(By.xpath("//input[@id='user']")).clear();
//      wd.findElement(By.xpath("//input[@id='user']")).sendKeys("dmitriy.konde@gmail.com");
        type(By.xpath("//input[@name='user']"), "dmitriy.konde@gmail.com");

        Thread.sleep(2000);
//      wd.findElement(By.xpath("//input[@id='login']")).click();
        click(By.xpath("//input[@id='login']"));

//      click(By.xpath("//*[@name='password']"));
//      wd.findElement(By.xpath("//*[@name='password']")).clear();
//      wd.findElement(By.xpath("//*[@name='password']")).sendKeys("Ddmitriy8805");
        type(By.xpath("//*[@name='password']"), "Ddmitriy8805");

        //confirmLogin
        click(By.xpath("//button[@id='login-submit']"));

        new WebDriverWait(wd, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='content-all-boards']")));


    }

}
