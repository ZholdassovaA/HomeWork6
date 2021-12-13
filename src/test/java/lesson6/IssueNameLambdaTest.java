package lesson6;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.partialLinkText;

public class IssueNameLambdaTest {
    private static final String REPOSITORY = "https://github.com/ZholdassovaA";


    @Owner("Aidana Zholdassova")
    @Feature("Repository webpage")
    @Story("Issues")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Lambda test")
    @Link(name = "GitHub", url = "https://github.com")

    @Test
    public void gitHubTestLambda() {

        step("Открыть страницу Github", () -> {
            open("https://github.com");
        });
        step("Находим нужный репозиторий" + REPOSITORY, () -> {
            $("[name=q]").setValue("ZholdassovaA/HomeWork1").submit();
        });
        step("Перейти в найденный репозиторий" + REPOSITORY, () -> {
            $(partialLinkText("ZholdassovaA/HomeWork1")).click();
        });
        step("Найти название Issues в репозиторий", () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });

    }

}
