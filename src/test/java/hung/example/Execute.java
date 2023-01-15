package hung.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static hung.example.DriverUtils.driver;
import static hung.example.DriverUtils.getText;

/**
 * @author thieunguyen
 * @Date Nov-08-2022
 */
public class Execute {
    //Todo: call method from DriverUtils to getLink you tube and convertMp3
//    public static WebDriver driver;
    public static void main(String[] args) {

        WebDriver webDriver;

        DriverUtils.initDriver();
        DriverUtils.navigateToULR(DATA.youtubeURL);

        String linkDownload = DriverUtils.getLinkOfVideo(1);
        String nameOfSong = DriverUtils.getTextByElement(youtubePage.listOfPlaylist, 1);

        DriverUtils.navigateToURLWithNewTab(DATA.convertMp3);

        DriverUtils.inputText(yt2mp3Page.inputLinkToConvert, linkDownload);

        DriverUtils.clickON(yt2mp3Page.convertButton);

        //Wait until Download button display
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(yt2mp3Page.downloadFile)));
        //Assert name of song between youtube page and download youtube page
        String textOfSongFromDownloadPage = getText(yt2mp3Page.NameOfSong);
//        String getTextOfSongFromDownloadPage = DriverUtils.getTextByAttribute(yt2mp3Page.NameOfSong, "label");
        Assert.assertEquals(nameOfSong, textOfSongFromDownloadPage);
        //click on download button
        DriverUtils.clickON((yt2mp3Page.downloadFile));


//        driver.close();

    }

}
