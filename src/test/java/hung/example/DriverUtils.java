package hung.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * @author thieunguyen
 * @Date Nov-08-2022
 */
public class DriverUtils {
    //Todo: Write all method to interact with browser

    public static WebDriver driver;

    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //todo: write method to navigate to url

    public static void navigateToULR(String URL){
        driver.get(URL);
    }

    //todo: get link of video
    public static String getLinkOfVideo (Integer indexSong){
        List<WebElement> listSong = driver.findElements(By.xpath("//a[@class='yt-simple-endpoint style-scope ytd-playlist-video-renderer']"));
        return listSong.get(indexSong).getAttribute("href");
    }


    //todo: write method to clickOn webElement
    public static void clickON (String webElement){
        driver.findElement(By.xpath(webElement)).click();
    }

    //todo: navigate link with new tab open
    public static void navigateToURLWithNewTab (String URL){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);
    }

    //todo: input text to field
    public static void inputText(String webElement, String TEXT){
        driver.findElement(By.xpath(webElement)).sendKeys(TEXT);
    }

    //todo: write method to getText

}
