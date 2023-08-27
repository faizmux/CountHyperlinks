package MyTests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class LinkedInImagePost extends BaseTest {

    @Test
    public void imagePost() throws InterruptedException, AWTException {
        System.out.println("Value of driver" + driver);
        driver.get("https://www.linkedin.com/login");
        //Enter your credentials in send keys
        driver.findElement(By.id("username")).sendKeys("user@gmail.com");
        driver.findElement(By.id("password")).sendKeys("User@1234");
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='Start a post']")).click();
        WebElement photoIcon = driver.findElement(By.xpath("(//button[@aria-label='Add a photo'])[1]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", photoIcon);

        Robot rb = new Robot();
        rb.delay(2000);

        StringSelection ss = new StringSelection("C:\\Users\\faizm\\Desktop\\Capture.PNG");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Done']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='Post successful.']")).isDisplayed();
    }

}
