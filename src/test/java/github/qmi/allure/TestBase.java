package github.qmi.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void browserSetting() {
        Configuration.startMaximized = true;

    }
}
