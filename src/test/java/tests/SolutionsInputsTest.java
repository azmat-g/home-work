package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SolutionsInputsTest {

    @Test
    public void solutionsInputsTest() {
        open("https://github.com/enterprise/contact?ref_cta=Contact+sales&ref_loc=hero&ref_page=%2Fsolutions_usecase_cicd");

        SelenideElement firstNameInput = $(By.id(":Rimb:"));
        SelenideElement lastNameInput = $(By.id(":R12mb:"));

        firstNameInput.click();
        firstNameInput.sendKeys("Azmat");

        lastNameInput.click();
        lastNameInput.setValue("Giniyatov");

        firstNameInput.shouldHave(value("Azmat"));
        lastNameInput.shouldHave(value("Giniyatov"));
    }

}
