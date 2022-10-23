package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class YaDiscPage {
    private WebDriver driver;

    private final String deleteButton = "//div[@class='groupable-buttons__visible-buttons']/span[4]";
    private final String copyButton = "//div[@class='groupable-buttons__visible-buttons']/span[5]";

    public YaDiscPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openDisc(){
        driver.findElement(By.xpath("//span[@class='avatar__image-wrapper']"))
                .click();
        driver.findElement(By.xpath("//span[@class='usermenu-redesign__item-inner usermenu-redesign__disk-inner']")).click();
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public void copyFileToFolder(String filename, String foldername) {
        driver.findElement(By.xpath("//div[@aria-label='" + filename + "']")).click();
        driver.findElement(By.xpath(copyButton)).click();
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
        driver.findElement(By.xpath("//div[@aria-label='delete.docx']")).click();
        driver.findElement(By.xpath(deleteButton)).click();
    }

    public void logOut() {
        driver.findElement(By.xpath("//img[@class='user-pic__image'][1]")).click();
        driver.findElement(By.xpath("//a[@aria-label='Выйти из аккаунта']")).click();
    }

    public String getFileName() {
        WebElement text = driver.findElement(By.xpath("//div[@aria-label='copy.jpg']"));
        return text.getText().replace("\n", "");
    }

}
