package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.ArrayList;

public class TestBase {
    private WebDriver driver;
    private static final String BASE_URL = "https://www.ya.ru/";

    public TestBase() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void openAuth() {
        driver.get(BASE_URL);
        driver.findElement(By.linkText("Войти")).click();
        clickByXPath("//button[@data-type='login']");
        sendLogin("yu.ra1l");
        sendPasswordAndEnter("super16Parol");
    }

    public void clickByLinkText(String text) {
        driver.findElement(By.linkText(text)).click();
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

    public void searchText(String text) {
        driver.findElement(By.name("text")).sendKeys(text);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void openYaDisc() {
        driver.findElement(By.xpath("//span[@class='avatar__image-wrapper']"))
                .click();
        driver.findElement(By.cssSelector("body > div.popup2.popup2_view_default.popup2_theme_normal.popup2_target_anchor.popup2_autoclosable_yes.popup2_redesign2_yes.popup2_new-profile_yes.popup2_scrollbar-hider_yes.i-bem.popup2_js_inited.popup2_direction_bottom-right.popup2_visible_yes > div > div > div.scrollbar__scrollable > div > div.usermenu-redesign__list > a.home-link2.usermenu-redesign__item.usermenu-redesign__disk"))
                .click();
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public void copyFileToFolder(String filename, String foldername) {
        driver.findElement(By.xpath("//div[@aria-label='" + filename + "']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Копировать']")).click();
        driver.findElement(By.xpath("//div[@title='" + foldername + "']")).click();
        driver.findElement(By.cssSelector(".confirmation-dialog__button_submit"))
                .click();
    }

    public void openFolder(String folderName) {
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.xpath("//div[@aria-label='" + folderName + "']"));
        actions.doubleClick(elementLocator).perform();
    }

    public void deleteAllFiles() {
        driver.findElement(By.xpath("//div[@aria-label='файл для удаления.docx']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Удалить']")).click();
    }

    public void sendKeys(String text, String xPath) {
        driver.findElement(By.xpath(text)).sendKeys(text);
    }

    public void logOut() {
        driver.findElement(By.cssSelector("#app > div > div > div.PSHeader.PSHeader_theme_light > div.PSHeader-Right > div > div > a.user-account.user-account_has-ticker_yes.user-account_has-accent-letter_yes.legouser__current-account.i-bem > div > img"))
                .click();
        driver.findElement(By.xpath("//a[@aria-label='Выйти из аккаунта']")).click();
    }

    public String getFileName() {
        WebElement text = driver.findElement(By.xpath("//span[@title='Скопировать.jpg']"));
        return text.getText().replace("\n", "");
    }

    @AfterTest
    public void tearDown() {
        logOut();
        driver.close();
        driver.quit();
    }
}
