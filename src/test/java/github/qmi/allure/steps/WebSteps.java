package github.qmi.allure.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Open main page")
    public WebSteps openMainPage() {
        open("https://github.com/");
        return this;
    }

    @Step("Search repository")
    public WebSteps searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
        return this;
    }

    @Step("Open repository")
    public WebSteps goToRepository(String repository) {
        $(linkText(repository)).click();
        return this;
    }

    @Step("Open Issues")
    public WebSteps openIssueTab() {
        $(partialLinkText("Issues")).click();
        return this;
    }

    @Step("Check Issue with number {number}")
    public WebSteps shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(Condition.visible);
        return this;
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs((OutputType.BYTES));
    }
}
