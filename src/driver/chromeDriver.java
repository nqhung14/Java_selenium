import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
package driver;

public class chromeDriver {
    public static void driverChrome {String[] args}{
        System.setProperty(
                "webdriver.chrome.driver",
                "H:\\Study\\Java_download_youtube\\Demo\\driver\\chromedriver.exe");

        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();

        // Maximize the browser
        driver.manage().window().maximize();
        return driver;
    }
}