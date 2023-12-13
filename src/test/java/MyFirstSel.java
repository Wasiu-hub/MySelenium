import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class MyFirstSel {

    // given I am on the next page
    // when I enter Jeans as a product and click on search button
    // then I should be able to see jeans as a result title

    @Test
    public void validateSearchJeans() {

        String expectedResult = "Jeans";
        String actualResult;

        WebDriverManager.chromedriver().setup(); // configures the browser
        WebDriver driver = new ChromeDriver(); // open browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //don't throw exceptions immediately, wait
        driver.manage().window().maximize(); // maximizing browser

        // driver.get("https://www.google.com/"); //launch URL
        driver.get("https://www.next.co.uk/"); //launch URL

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        driver.findElement(By.name("header-big-screen-search-box")).sendKeys("Jeans");// enter Jeans

        driver.findElement(By.xpath("//*[@id=\"header-search-form\"]/button/img")).click();

    }
}
