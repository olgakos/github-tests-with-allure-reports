import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssueSearch03Steps extends BaseTest {

    @Test
    void issueSearchTest03Steps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу GitHub", () -> {
            open("https://github.com");
        });
        step("Заполнить поле Поиск данными", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("olgakos/github-tests-with-allure-reports");
        });
        step("Нажать кнопку Поиск", () -> {
            $(".header-search-input").submit();
        });
        step("Проверить, что на открывшейся стр. есть кнопка Issues", () -> {
            $(By.partialLinkText("Issues")).should(Condition.exist);
        });
    }
}
