package labirint.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.function.Supplier;


public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebConfig config;
    public WebDriverProvider() {
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
