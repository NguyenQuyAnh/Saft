package saftTemplates;

import login.SetUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateSaftTest {
    private WebDriver driver;
    private String saftName;
    private String saftFilePath;
    private String userFilePath;
    @BeforeClass
    public void setUp()
    {
        this.driver = SetUp.setUp();
    }

    @Test
    public void mandatorySaftName() throws InterruptedException {
        saftName = "";
        saftFilePath = "D:\\Project\\Saft\\đã fill biến.docx";
        userFilePath = "D:\\Project\\Saft\\Saft_user_update - Copy.xls";
        CreateSaft createSaft = new CreateSaft(this.driver);
        createSaft.createSaftWithoutEmail(saftName,saftFilePath,userFilePath);

    }
}
