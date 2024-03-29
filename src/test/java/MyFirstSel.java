import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class MyFirstSel {
    WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.next.co.uk/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @After
    public void afterTest() {
        driver.close();
    }

    @Test
    public void validateSearchJeans() throws InterruptedException {

        // given I am on the next homepage
        // when I enter Jeans as a product and click on search button
        // then I should be able to see jeans as a result title

        String expectedResult = "\"Jeans\"";

        driver.findElement(By.name("header-big-screen-search-box")).sendKeys("Jeans");

        driver.findElement(By.xpath("//*[@id=\"header-search-form\"]/button/img")).click();

//        Thread.sleep(2000);

        String actualResult = driver.findElement(By.xpath("//*[@id=\"plp-results-title-container\"]/div/h1/span")).getText();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void validateSearchBasedOnShirtAsAProduct() {

        // given I am on the next homepage
        // when I enter Shirt as a product and click on search button
        // then I should be able to see Shirt as a result title

        String expectedResult = "\"Shirts\"";

        driver.findElement(By.id("header-big-screen-search-box")).sendKeys("Shirts");

        driver.findElement(By.xpath("//*[@id=\"header-search-form\"]/button/img")).click();

//        Thread.sleep(1000);

        String actualResult = driver.findElement(By.xpath("//*[@id=\"plp-results-title-container\"]/div/h1/span")).getText();

        Assert.assertEquals(expectedResult, actualResult);
    }
}
