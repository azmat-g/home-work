package configuration;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeAll
    public static void setConf(){
        Configuration.browser = "chrome";
    }
}
