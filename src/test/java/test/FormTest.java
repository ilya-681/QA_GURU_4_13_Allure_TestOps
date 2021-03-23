package test;


import config.WebConfig;
import io.qameta.allure.Feature;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest extends TestBase {

    @Test
    @Feature("Simple test")
    @DisplayName("Successful fill form test")
    void dataAfterSubmitForm() {

        final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
        open(config.getBaseURL());
        $("#firstName").setValue("Bob");
        $("#lastName").setValue("Jones");
        $("#userEmail").setValue("Jones@ya.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("8926123456");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(byText("1983")).click();
        $(".react-datepicker__month-select").click();
        $(byText("May")).click();
        $(byText("11")).click();

        $("#subjectsInput").setValue("Eng");
        $("#subjectsInput").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.PNG"));
        $("#currentAddress").setValue("Moscow, Main str");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        //assert
        $(".table-responsive").shouldHave(text("Bob"), text("Jones"), text("Jones@ya.ru"), text("Male"), text("8926123456"), text("11 May,1983"), text("English"), text("Music"), text("1.PNG"), text("Moscow, Main str"), text("NCR Delhi"));
    }
}
