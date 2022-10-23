package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.TestBase;

public class YaAndAuthPage {
    private WebDriver driver;

    public YaAndAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void auth(){
        driver.get(TestBase.BASE_URL);
//        driver.findElement(By.xpath("//a[@data-statlog='headline.enter']")).click();
        driver.findElement(By.linkText("Войти")).click();
        clickByXPath("//button[@data-type='login']");
        sendLogin("yu.ra1l");
        sendPasswordAndEnter("super16Parol");
    }

    public void clickByXPath(String text) {
        driver.findElement(By.xpath(text)).click();
    }

    public void sendLogin(String text) {
        driver.findElement(By.xpath("//input[@data-t='field:input-login']")).sendKeys(text);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void sendPasswordAndEnter(String text) {
        driver.findElement(By.xpath("//input[@data-t='field:input-passwd']")).sendKeys(text);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}
