package labirint.helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AllureAttachments {

    @Attachment(value = "{attachName}", type = "text/plain")
    private static String addMessage(final String attachName, final String text) {
        return text;
    }

    public static void addBrowserConsoleLogs() {
        addMessage("Browser console logs", DriverUtils.getConsoleLogs());
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] addScreenshotAs(final String attachName) {
        return DriverUtils.getScreenshotAsBytes();
    }

    @Attachment(value = "Page source", type = "text/html")
    public static byte[] addPageSource() {
        return DriverUtils.getPageSourceAsBytes();
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {

        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + DriverUtils.getVideoUrl()
                + "' type='video/mp4'></video></body></html>";
    }
}