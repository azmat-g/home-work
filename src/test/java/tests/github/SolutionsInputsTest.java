package tests.github;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageObject.CiCdPage;
import pageObject.ContactSalesPage;
import pageObject.MainPage;
import uiConfiguration.BaseTest;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SolutionsInputsTest extends BaseTest {

    @Test
    public void solutionsInputsTest() {
        open("/");

        new MainPage().openCiCdPage();
        new CiCdPage().openContactSalesPage();

        ContactSalesPage contactSalesPage = new ContactSalesPage();

        String firstName = "Azmat";
        String lastName = "Giniyatov";

        contactSalesPage.setFirstNameAndLastName(firstName, lastName);

        contactSalesPage.getFirstNameInput().shouldHave(value(firstName));
        contactSalesPage.getLastNameInput().shouldHave(value(lastName));
    }

}
