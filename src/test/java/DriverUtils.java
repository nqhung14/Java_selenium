import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author thieunguyen
 * @Date Nov-08-2022
 */
public class DriverUtils {
    public static void initChromeDriver(WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
