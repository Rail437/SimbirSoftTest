package testapi.test;

import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test
    public void testFolderCreation(){
        String folderName = "SimbirSoft";
        folderCreation(folderName);
        folderCheck(folderName);
        folder = folderName;
    }
}
