package lesson6;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Поиск элементов на странице репозитория с использованием аннотации")

public class IssueNameAttachmentTest extends WebSteps {

    private static final String REPOSITORY = "ZholdassovaA/HomeWork1";
    private WebSteps steps = new WebSteps();

    @Test
    @Owner("Aidana Zholdassova")
    @Feature("Repository webpage")
    @Story("Issues")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Annotated Test")
    @Link(name = "GitHub", url = "https://github.com")
    public void searchingIssueTitleTest() {
        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.searchingIssueTitle();
        steps.takeScreenshot();

    }

}
