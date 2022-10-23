package testselenium.test;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends TestBase {
    private final String FILE_NAME = "copy.jpg";
    private final String FOLDER_NAME = "copyes";

    @Test
    @Description("Проверка копирования файла.")
    public void fileCopyTest() {
        openYaDisc();
        copyFileToFolder(FILE_NAME, FOLDER_NAME);
        openFolder(FOLDER_NAME);
        Assert.assertEquals(FILE_NAME, getFileName());
    }

    @Test
    @Description("Проверка удаления файла.")
    public void fileDeletionTest() {
        deleteFile();
        Assert.assertFalse(getDeleteFile());
    }
}
