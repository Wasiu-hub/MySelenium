import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class MyFirstSel {

    @Test
    public void validateSearchJeans() {

        // given I am on the next homepage
        // when I enter Jeans as a product and click on search button
        // then I should be able to see jeans as a result title

        String expectedResult = "\"Jeans\"";

        WebDriverManager.chromedriver().setup(); // configures the browser
        WebDriver driver = new ChromeDriver(); // open browser

        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //don't throw exceptions immediately, wait - test passed here without it, but not in safari

        driver.manage().window().maximize(); // maximizing browser

        // driver.get("https://www.google.com/"); //launch URL
        driver.get("https://www.next.co.uk/"); //launch URL

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        driver.findElement(By.name("header-big-screen-search-box")).sendKeys("Jeans"); // enter Jeans

        driver.findElement(By.xpath("//*[@id=\"header-search-form\"]/button/img")).click(); // click on search button

        // Thread.sleep(2000); // test passed without this but not          in safari

        String actualResult = driver.findElement(By.xpath("//*[@id=\"plp-results-title-container\"]/div/h1/span")).getText();

        Assert.assertEquals(expectedResult, actualResult);

        driver.close();
    }

    @Test
    public void validateSearchBasedOnShirtAsAProduct() {
        // given I am on the next homepage
        // when I enter Shirt as a product and click on search button
        // then I should be able to see Shirt as a result title

        String expectedResult = "\"Shirts\"";

        // configure the browser to use
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // maximizing window
        driver.manage().window().maximize();

        // launch URL
        driver.get("https://www.next.co.uk/");

        // enter element
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();// this fails on safari because this line is executed after loading the above page, so it couldn't accept the cookies.

        // find element by search button
        driver.findElement(By.id("header-big-screen-search-box")).sendKeys("Shirts");

        driver.findElement(By.xpath("//*[@id=\"header-search-form\"]/button/img")).click();

        String actualResult = driver.findElement(By.xpath("//*[@id=\"plp-results-title-container\"]/div/h1/span")).getText();

        Assert.assertEquals(expectedResult, actualResult);
        driver.close();
    }
}
