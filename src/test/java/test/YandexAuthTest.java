package test;

import com.codeborne.selenide.Condition;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class YandexAuthTest {

    @Test
    @AllureId("2025")
    @DisplayName("Unsuccessful yandex auth")
    void unsuccessfulYandexAuthTest() {

        step("Open yandex page", () -> open("https://ya.ru/"));

        step("Fill the form", () -> {
            $(byText("Войти в почту")).click();
            $(".HeadBanner-Button-Enter").click();
            $("#passp-field-login").val("testAcc").pressEnter();
            $("#passp-field-passwd").val("123456").pressEnter();
        });

        step("Verify unsuccessful auth", () -> $(byText("Доступ к аккаунту ограничен")).shouldBe(Condition.visible));
    }
}
