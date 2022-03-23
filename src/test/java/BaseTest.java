import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.browserSize;

public class BaseTest {

    @BeforeEach
    void preconditionBrowser() {
        browserSize = "1920x1080";
    }
    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

}
