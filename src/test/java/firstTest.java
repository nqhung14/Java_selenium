import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class firstTest {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        DriverUtils.initChromeDriver(driver);
        getLinkOfVideo(1);
        convertToMp3_2(getLinkOfVideo(1));

    }

    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static String getLinkOfVideo(Integer indexSong) {

        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/playlist?list=PLxKLMN7WdG5AtunfydnC6JjVRg6ZHuv5O");

        List<WebElement> listSong = driver.findElements(By.xpath("//a[@class='yt-simple-endpoint style-scope ytd-playlist-video-renderer']"));
        return listSong.get(indexSong).getAttribute("href");
    }

    public static void convertToMp3(String linkOfSong, WebDriver driver) throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("https://yt2mp3.info/?l=en");
        driver.findElement(By.xpath("//input[@id='input']")).sendKeys(linkOfSong);
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        Thread.sleep(3000);
        String buttonDownloadMp3 = "//a[@onclick='downloaddata('320')']";
        String buttonPlayMp3 = "//tr//td//a[@onclick='playmp3()']";
//       driver.findElement(By.xpath(buttonDownloadMp3)).click();
//       driver.findElement(By.xpath(buttonPlayMp3)).click();

    }

    public static void convertToMp3_2(String linkOfSong) throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("https://yt2mp3.info/?l=en");
        driver.findElement(By.xpath("//input[@id='input']")).sendKeys(linkOfSong);
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        Thread.sleep(5000);
//        String buttonDownloadMp3 = "/html/body/div/div[2]/div[3]/div[1]/table/thead/tr/td[2]/a[1]/span";
        String buttonDownloadMp3 = "//a[@onclick='downloaddata('320')']";

//        String buttonPlayMp3 = "//tr//td//a[@onclick='playmp3()']";
        driver.findElement(By.xpath(buttonDownloadMp3)).click();


    }

    public static void closeDriver(WebDriver driver) {
        driver.close();
    }
}

