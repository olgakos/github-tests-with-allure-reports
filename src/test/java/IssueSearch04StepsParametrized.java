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

public class IssueSearch04StepsParametrized extends BaseTest {
    private static final String REPOSITORY = "olgakos/github-tests-with-allure-reports";
    private static final String LINK_NAME = "Issues";

    @Test
    void issueSearchTest04StepsParametrized() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу GitHub", () -> {
            open("https://github.com");
        });
        step("Заполнить поле Поиск данными: " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
        });
        step("Нажать кнопку Поиск", () -> {
            $(".header-search-input").submit();
        });
        step("Проверить, что на открывшейся стр. есть кнопка " + LINK_NAME, () -> {
            $(By.partialLinkText(LINK_NAME)).should(Condition.exist);
        });
    }
}
