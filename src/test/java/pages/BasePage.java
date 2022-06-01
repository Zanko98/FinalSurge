package pages;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

public class BasePage {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "edge";
        Configuration.baseUrl = "https://log.finalsurge.com/";
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
        // Configuration.holdBrowserOpen = true;
    }
}
