package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends TestBase {

    @Test
    public void Test() {
        openAuth();
        openYaDisc();
        copyFileToFolder("copy.jpg","copyes");
        openFolder("copyes");
        deleteAllFiles();
        Assert.assertEquals("copy.jpg", getFileName());
    }
}
