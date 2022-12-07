package labirint.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/web/remote.properties",
        "classpath:config/web/local.properties"
})

public interface WebConfig extends Config {
    @DefaultValue("chrome")
    String browser();

    @DefaultValue("102")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();

    @DefaultValue("https://labirint.ru/")
    String baseUrl();

    @Key("isRemote")
    boolean isRemote();

    @DefaultValue("")
    String remoteUrl();

    @DefaultValue("")
    String selenoidLogin();

    @DefaultValue("")
    String selenoidPassword();
}