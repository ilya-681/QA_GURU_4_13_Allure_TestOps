package test;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

public class FormTestWithPageObjects extends TestBase {
    StudentRegistrationPage studentRegistrationPage;

    @Test
    @Feature("PageObject feature")
    @DisplayName("Successful fill form test with PageObjectTest")
    void successfulFillFormTest() {
        studentRegistrationPage = new StudentRegistrationPage();

        studentRegistrationPage.openPage();
        studentRegistrationPage.fillForm();
        studentRegistrationPage.sendForm();
        studentRegistrationPage.verifyForm();
    }
}
