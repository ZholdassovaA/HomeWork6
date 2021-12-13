package lesson6;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.partialLinkText;

public class IssueNameSelenideListenerTest {
    @Test
    public void gitHubTestWithListener() {
        // Добавление Листенера Allure
        SelenideLogger.addListener("allure", new AllureSelenide());

        // Открываем страницу GitHub
        open("https://github.com/");

        // Находим нужный репозиторий
        $("[name=q]").setValue("ZholdassovaA/HomeWork1").submit();

        // Перейти в найденный репозиторий
        $(partialLinkText("ZholdassovaA/HomeWork1")).click();

        // Найти название Issues в репозиторий
        $("#issues-tab").shouldHave(text("Issues"));


    }


}
