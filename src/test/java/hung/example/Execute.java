package hung.example;

import com.github.dockerjava.api.model.Driver;
import org.openqa.selenium.WebDriver;

/**
 * @author thieunguyen
 * @Date Nov-08-2022
 */
public class Execute {
    //Todo: call method from DriverUtils to getLink you tube and convertMp3
//    public static WebDriver driver;
    public static void main(String[] args) {

        DriverUtils.initDriver();
        DriverUtils.navigateToULR(DATA.youtubeURL);

        String linkDownload = DriverUtils.getLinkOfVideo(1);

        DriverUtils.navigateToURLWithNewTab(DATA.convertMp3);
        DriverUtils.inputText(POM.inputLinkConvert, linkDownload);
        DriverUtils.clickON(POM.submitButton);
        DriverUtils.clickON(POM.buttonDownloadMp3);
    }
}
