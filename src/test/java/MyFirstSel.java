import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

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
        driver.manage().window().maximize();


    }
}
