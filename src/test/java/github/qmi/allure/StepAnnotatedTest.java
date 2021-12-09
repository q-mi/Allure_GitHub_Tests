package github.qmi.allure;

import github.qmi.allure.steps.WebSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    private final WebSteps steps = new WebSteps();

    @Test
    @Owner("Tsareva")
    @Feature("Search test")
    @Story("Search 'eroshenkoam/allure-example' and check Issue")
    @DisplayName("Search Issue with number #68 test")
    @Link(name = "Github", url = "https://github.com")
    public void checkIssue() {

        steps.openMainPage()
                .searchForRepository(REPOSITORY)
                .goToRepository(REPOSITORY)
                .openIssueTab()
                .shouldSeeIssueWithNumber(ISSUE_NUMBER)
                .takeScreenshot();
    }

}
