package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginAdmin {
    private By formInput = By.xpath("//form//input");
    private By loginBtn = By.xpath("//form//button");
    private By title = By.xpath("//p[contains(text(),'SAFT GENERATOR')]");
    private By fieldMessage = By.className("MuiFormHelperText-root");
    private By formMessage = By.className("css-17a04ne-MuiTypography-root");

    private WebDriver driver;

    public LoginAdmin(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String pw)
   {
       driver.navigate().to("https://saft-gen-admin.sotatek.works/login");
       Helper.sleep(2000);
       List<WebElement> elements = driver.findElements(formInput);
       elements.get(0).sendKeys(email);
       elements.get(1).sendKeys(pw);
       WebElement loginElement = driver.findElement(loginBtn);
       if (loginElement.isEnabled())
           loginElement.click();
       Helper.sleep(3000);
   }

   public boolean verifySaftTemplates()
   {
       return driver.findElement(title).isDisplayed();
   }

   public String getFieldMessage()
   {
       return driver.findElement(fieldMessage).getText();
   }
   public String getFormMessage()
   {
       return driver.findElement(formMessage).getText();
   }
}
