package testselenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import testselenium.model.YaAndAuthPage;
import testselenium.model.YaDiscPage;
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

    public void openYaDisc() {
        yaDiscPage.openDisc();
    }

    public void copyFileToFolder(String filename, String foldername) {
        yaDiscPage.copyFileToFolder(filename, foldername);
    }

    public void openFolder(String folderName) {
        yaDiscPage.openFolder(folderName);
    }

    public void deleteFile() {
        yaDiscPage.deleteAllFiles();
    }

    public void logOut() {
        yaDiscPage.logOut();
    }

    public String getFileName() {
        return yaDiscPage.getFileName();
    }

    public boolean getDeleteFile() {
        return yaDiscPage.getDeleteFile();
    }

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        openAuth();
    }

    @AfterTest
    public void tearDown() {
        logOut();
        driver.close();
        driver.quit();
    }
}
