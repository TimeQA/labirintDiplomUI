package labirint.config.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.function.Supplier;

import static com.codeborne.selenide.Browsers.*;

public class WebProvider implements Supplier<WebDriver> {

    private final WebConfig config;

    public WebProvider() {
        this.config = ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createDriver();
        driver.get(config.baseUrl());
        return driver;
    }

    public WebDriver createDriver() {
        switch (config.browser()) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case EDGE: {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            default: {
                throw new RuntimeException("No such driver");
            }
        }
    }

}