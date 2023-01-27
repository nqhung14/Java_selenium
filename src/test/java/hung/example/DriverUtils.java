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

    public static void navigateToULR(String URL) {
        driver.get(URL);
    }

    //todo: get link of video
    public static String getLinkOfVideo(Integer indexSong) {
        List<WebElement> listSong = driver.findElements(By.xpath(youtubePage.listOfPlaylist));
        return listSong.get(indexSong).getAttribute("href");
    }

    //Get size of list video
    public static Integer lenghtOfListVideo(){
        return driver.findElements(By.xpath(youtubePage.listOfPlaylist)).size();
    }

    //todo: write method to clickOn webElement
    public static void clickON(String webElement) {
        driver.findElement(By.xpath(webElement)).click();
    }

    public static String getNameOfSong(String webElement, int indexElement) {
        List<WebElement> getTextByElement = driver.findElements(By.xpath(webElement));
        return getTextByElement.get(indexElement).getText();
    }

//    public static String getNameOfSong(int indexElement){
//        List<WebElement> getTextByElement = driver.findElements(By.xpath(youtubePage.listOfPlaylist));
//        return getTextByElement.get(indexElement).getText();
//    }

    //todo: navigate link with new tab open
    public static void navigateToURLWithNewTab(String URL) {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);
    }

    //todo: input text to field
    public static void inputText(String webElement, String TEXT) {
        driver.findElement(By.xpath(webElement)).sendKeys(TEXT);
    }

    //todo: write method to getText
    public static String getText(String getTextOfElement) {
        WebElement text = driver.findElement(By.xpath(getTextOfElement));
        return text.getText();
    }

    public static String getTextByAttribute(String getTextOfElement, String value) {
        WebElement text = driver.findElement(By.xpath(getTextOfElement));
        return text.getAttribute(value);
    }
}
