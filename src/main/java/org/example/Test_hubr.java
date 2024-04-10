package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_hubr {
    @Test
    public void habr() throws InterruptedException{

        //Установка пути к драйверу Chrome
        System.setProperty("webdriver.chorme.driver", "C:\\Users\\maxim\\Desktop\\test_maven\\drivers\\chromedriver-win64\\chromedriver.exe");
        // Создание драйвера, открытие драйвера
        WebDriver driver = new ChromeDriver();
        driver.get("https://habr.com/ru/all/");


        // Нажатие на кнопку перехода в поиск
        driver.findElement(By.xpath("//a[@href='/ru/search/']")).click();
        Thread.sleep(Duration.ofSeconds(2L).toMillis());

        // Проверка акивности элемента
        Assert.assertEquals(driver.findElement((By.xpath("//input[@name='q']"))), driver.switchTo().activeElement());
        Thread.sleep(Duration.ofSeconds(2L).toMillis());

        // Ввод значения для поиска
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium WebDriver");
        Thread.sleep(Duration.ofSeconds(2L).toMillis());

        // Выполнение поиска
        driver.findElement(By.xpath("//*[@class='tm-svg-img tm-svg-icon']")).click();
        Thread.sleep(Duration.ofSeconds(2L).toMillis());

        // Переход в статью
        driver.findElement(By.linkText("Что такое Selenium WebDriver?")).click();
        Thread.sleep(Duration.ofSeconds(2L).toMillis());

        // Сравнение даты
        Assert.assertEquals("1 окт 2012 в 16:40", driver.findElement(By.xpath("//*[@datetime='2012-10-01T09:40:36.000Z']")).getText());

        // Скролл страницы
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(Duration.ofSeconds(2L).toMillis());
        // Переход в Статьи
        driver.findElement(By.xpath("//a[@href='/ru/articles/' and @class='footer-menu__item-link router-link-active']")).click();
        //Таймаут
        Thread.sleep(Duration.ofSeconds(2L).toMillis());

        // Закрытие драйвера
        driver.quit();
    }
}
