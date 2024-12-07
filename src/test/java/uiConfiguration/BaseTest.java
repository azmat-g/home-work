package uiConfiguration;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setConf(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://github.com";
        // Configuration.browserSize = "1920x1080";
    }
}
