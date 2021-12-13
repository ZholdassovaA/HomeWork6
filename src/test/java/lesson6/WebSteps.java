package lesson6;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {
    @Step("Открыть страницу Github")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Находим нужный репозиторий")
    public void searchRepository(String repository) {
        $("[name=q]").setValue(repository).submit();
    }

    @Step("Перейти в найденный репозиторий")
    public void goToRepository(String repository) {
        $(partialLinkText(repository)).click();
    }

    @Step("Найти название Issues в репозиторий")
    public void searchingIssueTitle() {
        $("#issues-tab").shouldHave(text("Issues"));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
