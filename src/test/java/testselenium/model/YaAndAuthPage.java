package testselenium.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testselenium.test.TestBase;

public class YaAndAuthPage {
    private WebDriver driver;
    private String username = "yu.ra1l";
    private String password = "super16Parol";

    public YaAndAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void auth(){
        driver.get(TestBase.BASE_URL);
        driver.findElement(By.linkText("Войти")).click();
        clickByXPath("//button[@data-type='login']");
        sendLogin(username);
        sendPasswordAndEnter(password);
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
