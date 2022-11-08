package hung.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author thieunguyen
 * @Date Nov-08-2022
 */
public class DriverUtils {
    //Todo: Write all method to interact with browser
    public static void initDriver(WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //todo: write method to navigate to url

    //todo: write method to clickOn webElement

    //todo: write method to getText

}
