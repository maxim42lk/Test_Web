package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    @Test
    public void FirstTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\maxim\\Desktop\\test_maven\\drivers\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.ru/");
        Thread.sleep(Duration.ofSeconds(2).toMillis());

        driver.findElement(By.xpath("//*[@class='resplash-btn resplash-btn_primary resplash-btn_mailbox-big dcd-cfdg-b85yax']")).click();

        Thread.sleep(Duration.ofSeconds(5).toMillis());

        WebElement iframeElement = driver.findElement(By.cssSelector("iframe.ag-popup__frame__layout__iframe"));

        driver.switchTo().frame(iframeElement);

        driver.findElement(By.xpath("//*[@class='input-0-2-71']")).sendKeys("labtest10");
        driver.findElement(By.xpath("//*[contains(@class, 'inner-0-2-81 innerTextWrapper-0-2-82')]")).click();
        driver.findElement(By.xpath("//*[@class='inner-0-2-81 innerTextWrapper-0-2-82']")).click();
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        driver.findElement(By.xpath("//*[@class='input-0-2-71 withIcon-0-2-72']")).sendKeys("123414123a");
        driver.findElement(By.xpath("//*[@class='inner-0-2-81 innerTextWrapper-0-2-82']")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        driver.findElement(By.xpath("//*[@class='ph-avatar-img svelte-dfhuqc']")).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        Assert.assertEquals("v v",driver.findElement(By.xpath("//*[@class='ph-name svelte-1popff4']")).getText());
        driver.findElement(By.xpath("//*[@data-testid='whiteline-account-exit']")).click();
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        driver.findElement(By.xpath("//*[@class='resplash-btn resplash-btn_outlined-themed resplash-btn_mailbox-big dcd-cfdg-b85yax']")).isDisplayed();

        driver.quit();
    }

}