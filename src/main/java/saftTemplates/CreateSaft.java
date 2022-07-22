package saftTemplates;

import login.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class CreateSaft {
    private By saftNameTextBox = By.xpath("//input[placeholder = 'Please enter']");
    private By saftFileBtn = By.id(" ");
    private By userFileBtn = By.id(" ");
    private By checkbox = By.id(" ");
    private By createBtn = By.id(" ");
    private String saftName;
    private String saftFilePath = "";
    private String userFilePath = "";
    private By newSaftName = By.xpath("//tr//td[2]");
    private WebDriver driver;

    public CreateSaft(WebDriver driver)
    {
        this.driver = driver;
    }

    public void createSaftWithEmail() throws InterruptedException {
        driver.findElement(saftNameTextBox).sendKeys(saftName);
        driver.findElement(saftFileBtn).sendKeys(System.getProperty("user.dir") + saftFilePath);
        Helper.sleep(1000);
        driver.findElement(userFileBtn).sendKeys(System.getProperty("user.dir") + userFilePath);
        Helper.sleep(1000);
        driver.findElement(checkbox).click();
        driver.findElement(createBtn).click();
    }

    public void createSaftWithoutEmail() throws InterruptedException {
        driver.findElement(saftNameTextBox).sendKeys(saftName);
        driver.findElement(saftFileBtn).sendKeys(System.getProperty("user.dir") + saftFilePath);
        Helper.sleep(1000);
        driver.findElement(userFileBtn).sendKeys(System.getProperty("user.dir") + userFilePath);
        Helper.sleep(1000);
        driver.findElement(createBtn).click();
    }

    public boolean verifyCreateSaft()
    {
        return driver.findElement(newSaftName).getText().contains(saftName);
    }
}
