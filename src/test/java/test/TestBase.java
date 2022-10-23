package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.YaAndAuthPage;
import model.YaDiscPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {
    private WebDriver driver;
    public static final String BASE_URL = "https://www.ya.ru/";
    private YaAndAuthPage yaAndAuthPage;
    private YaDiscPage yaDiscPage;

    public TestBase() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.yaAndAuthPage = new YaAndAuthPage(driver);
        this.yaDiscPage = new YaDiscPage(driver);
    }

    public void openAuth() {
        yaAndAuthPage.auth();
    }

    public void clickByLinkText(String text) {
        driver.findElement(By.linkText(text)).click();
    }

    public void searchText(String text) {
        driver.findElement(By.name("text")).sendKeys(text);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void openYaDisc() {
        yaDiscPage.openDisc();
    }

    public void copyFileToFolder(String filename, String foldername) {
        yaDiscPage.copyFileToFolder(filename,foldername);
    }

    public void openFolder(String folderName) {
        yaDiscPage.openFolder(folderName);
    }

    public void deleteAllFiles() {
        yaDiscPage.deleteAllFiles();
    }

    public void logOut() {
      yaDiscPage.logOut();
    }

    public String getFileName() {
        return yaDiscPage.getFileName();
    }

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void tearDown() {
        logOut();
        driver.close();
        driver.quit();
    }
}
