package webLoadTest.test.v1;

import org.testng.annotations.Test;
import webLoadTest.test.TestBaseBrowser;
import webLoadTest.utilities.*;


public class SampleTest extends TestBaseBrowser {

    String newFileName,fileDownloadFolder,uploadPath1,uploadPath2,compare3;


    @Test
    public void First() throws Exception {

        System.out.println("First Keshav ");

        System.out.println("Host is :: "+GlobalVars.HOST);
        System.out.println("Password is :: "+GlobalVars.SFTP_AUTH_PASSWORD);
        System.out.println("Username is :: "+GlobalVars.SFTP_AUTH_USERNAME);
        System.out.println("Port is :: "+GlobalVars.PORT);



    }

}
