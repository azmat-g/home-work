package tests.github;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageObject.DashboardPage;
import pageObject.SignInPage;
import uiConfiguration.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTest extends BaseTest {

    @BeforeEach
    public void openPage(){
        open(new SignInPage().getPageUrl());
        new SignInPage().isSubmitButtonDisplayed();
    }

    @Test
    public void validEmailAndPassword(){

        SignInPage signInPage = new SignInPage();

        signInPage.authOperation("azmat-g", "correctPassword");

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.getAvatar().shouldBe(visible);
        dashboardPage.logOut();
    }

    @Test
    public void invalidEmailAndPassword(){

        SignInPage signInPage = new SignInPage();

        signInPage.authOperation("azmat-g", "azmat");

        SelenideElement incorrectUsernameMessage = $(By.className("js-flash-alert"));
        incorrectUsernameMessage.shouldBe(visible);
    }
}
