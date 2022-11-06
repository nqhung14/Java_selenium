import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class firstTest {
    public static void main(String[] args)
    {
        getLinkOfVideo(1, chromeDriver());
//        convertToMp3(getLinkOfVideo(1, chromeDriver()), chromeDriver());

    }

    public static WebDriver chromeDriver (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static void getLinkOfVideo (Integer indexSong, WebDriver driver){

        driver.manage().window().maximize();

        driver.get("https://www.youtube.com/playlist?list=PLxKLMN7WdG5AtunfydnC6JjVRg6ZHuv5O");

        List<WebElement> listSong = driver.findElements(By.xpath("//a[@class='yt-simple-endpoint style-scope ytd-playlist-video-renderer']"));
        String linkOfSong = listSong.get(indexSong).getAttribute("href");
        System.out.println(linkOfSong);
//        return linkOfSong;
    }

    public static void convertToMp3 (String linkOfSong, WebDriver driver)
    {

       driver.manage().window().maximize();
       driver.get("https://yt2mp3.info/?l=en");
       driver.findElement(By.xpath("//input[@id='input']")).sendKeys(linkOfSong);
       driver.findElement(By.xpath("//button[@id='submit']")).click();

    }

}

