import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {

    private final static String Repository = "eroshenkoam/allure-example";
    private final static Integer Issue_Number = 68;

    @Test
    public void testGithub() {

        step("Открываем главную страницу",() -> {
            open("https://github.com");
        });


        step("Смотрим репозиторий " + Repository,() -> {
            $(".header-search-input").setValue(Repository).submit();
        });


        step("Переходим в репозиторий " + Repository, () -> {
            $(linkText(Repository)).click();
        });
        step("Открываем разедел Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем наличие Issue с номером " + Issue_Number, () -> {
            $(byText("#" + Issue_Number)).should(Condition.visible);
        });

    }




}
