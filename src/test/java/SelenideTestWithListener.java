import com.codeborne.selenide.Condition;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.logevents.SelenideLogger;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTestWithListener {

    @Test
    public void testGithub() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").as("Смотрим репозиторий ").setValue("eroshenkoam/allure-example").submit();

        $(linkText("eroshenkoam/allure-example")).as("Переходим в репозиторий ").click();
        $(partialLinkText("Issues")).as("Открываем разедел Issues").click();
        $(byText("68")).as("Проверяем наличие Issue с номером ").should(Condition.visible);
    }
}
