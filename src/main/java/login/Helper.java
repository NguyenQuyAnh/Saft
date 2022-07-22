package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {
    public static WebElement waitUtil(WebDriver driver, int time, By element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            throw new RuntimeException("test");
        }
    }

    public static void sleep(int time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
