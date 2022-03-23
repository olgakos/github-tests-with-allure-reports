import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

//класс1: данные и методы
public class IssueSearch05WebSteps {
    private static final String REPOSITORY = "olgakos/github-tests-with-allure-reports";
    private static final String LINK_NAME = "Issues";

        @Step("Открыть главную страницу GitHub")
        public void openPage(){
            open("https://github.com");
        }

        @Step("Заполнить поле Поиск данными: " + REPOSITORY)
        public void fillData(){
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
        }

        @Step("Нажать кнопку Поиск")
        public void pressButton(){
            $(".header-search-input").submit();
        }

        @Step("Проверить, что на открывшейся стр. есть кнопка " + LINK_NAME)
        public void findText(){
            $(By.partialLinkText(LINK_NAME)).should(Condition.exist);
        }

        @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
        public byte[] takeScreenshot() {
            return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        }
}

//класс2: тестовый

    class IssueSearch05WebStepsTest extends BaseTest {

        @Test
        void issueSearchTest05WebSteps() {

            SelenideLogger.addListener("allure", new AllureSelenide());

            IssueSearch05WebSteps steps = new IssueSearch05WebSteps();

            steps.openPage();
            steps.fillData();
            steps.pressButton();
            steps.findText();
            steps.takeScreenshot();
        }





    }
