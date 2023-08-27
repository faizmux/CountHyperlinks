package MyTests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CountHyperlink extends BaseTest {

    @Test
    public void countHyperLinks() {
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }

}
