package login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    private WebDriver driver;
    private String email;
    private String password;

    @BeforeMethod
    public void setUp()
    {
        this.driver = SetUp.setUp();
    }

    @Test
    public void loginSuccessful()
    {
        email = "admin-saft@sotatek.com";
        password = "saft@2022";
        LoginAdmin login = new LoginAdmin(this.driver);
        login.login(email, password);
        Assert.assertTrue(login.verifySaftTemplates());
    }
    @Test
    public void manatoryEmail()
    {
        email = "";
        password = "saft@2022";
        LoginAdmin login = new LoginAdmin(this.driver);
        login.login(email, password);
        Assert.assertTrue(login.getFieldMessage().contains("Email is required"));
    }
    @Test
    public void manatoryPassword()
    {
        email = "admin-saft@sotatek.com";
        password = "";
        LoginAdmin login = new LoginAdmin(this.driver);
        login.login(email, password);
        Assert.assertTrue(login.getFieldMessage().contains("Password is required"));
    }
    @Test
    public void validateEmail()
    {
        email = "admin-saft@sotatek";
        password = "saft@2022";
        LoginAdmin login = new LoginAdmin(this.driver);
        login.login(email, password);
        Assert.assertTrue(login.getFormMessage().contains("Incorrect email or password"));

    }
    @Test
    public void validatePassword()
    {
        email = "admin-saft@sotatek.com";
        password = "saft@";
        LoginAdmin login = new LoginAdmin(this.driver);
        login.login(email, password);
        Assert.assertTrue(login.getFormMessage().contains("Incorrect email or password"));

    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
