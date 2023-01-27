package hung.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
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
    @Test
    public static void main(String[] args) {

        DriverUtils.initDriver();
        DriverUtils.navigateToULR(DATA.youtubeURL);

        int countSong = DriverUtils.lenghtOfListVideo();

        ArrayList<String> linkOfVideo = new ArrayList<>();
        ArrayList<String> nameOfSong = new ArrayList<>();

        for (int x = 0; x < countSong; x++){
            linkOfVideo.add(DriverUtils.getLinkOfVideo(x));
            nameOfSong.add(DriverUtils.getNameOfSong(youtubePage.listOfPlaylist, x));
        }

        for (int y=0; y < countSong; y++){
            DriverUtils.navigateToURLWithNewTab(DATA.convertMp3);
            DriverUtils.inputText(yt2mp3Page.inputLinkToConvert, linkOfVideo.get(y));
            DriverUtils.clickON(yt2mp3Page.convertButton);
            //Wait until Download button display
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(yt2mp3Page.downloadFile)));
            String textOfSongFromDownloadPage = getText(yt2mp3Page.NameOfSong);
            //Assert name of song between youtube page and download youtube page
            Assert.assertEquals(nameOfSong.get(y), textOfSongFromDownloadPage);
            //Download mp3 file
            DriverUtils.clickON((yt2mp3Page.downloadFile));
        }
        driver.close();
            }
        }

