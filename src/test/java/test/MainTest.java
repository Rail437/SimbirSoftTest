package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends TestBase {

    @Test
    public void Test() throws InterruptedException {
        openAuth();
        openYaDisc();
        copyFileToFolder("Скопировать.jpg","копии");
        openFolder("копии");
        deleteAllFiles();
        Assert.assertEquals("Скопировать.jpg", getFileName());
    }
}
