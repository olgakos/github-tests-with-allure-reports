import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssueSearch01JustSelenide {

    @BeforeEach
    void preconditionBrowser() {
        browserSize = "1920x1080";
    }
    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    void issueSearchTest01JustSelenide() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("olgakos/github-tests-with-allure-reports");
        $(".header-search-input").submit();
        $(By.partialLinkText("Issues")).should(Condition.exist);
    }
}
