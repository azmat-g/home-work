package tests.github;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTest {

    @Test
    public void validEmailAndPassword(){
        open("https://github.com/login");

        SelenideElement loginInput = $(By.id("login_field"));
        SelenideElement passwordInput = $(By.id("password"));
        SelenideElement submitButton = $(By.name("commit"));

        loginInput.click();
        loginInput.sendKeys("azmat-g");
        passwordInput.click();
        passwordInput.sendKeys("87055450152azmatgithub23001");
        submitButton.click();

        SelenideElement avatar = $(By.xpath("//*[@class=\"avatar circle\"]"));
        avatar.shouldBe(visible);

        avatar.click();
        SelenideElement signOutButton = $(By.id(":r10:--label"));
        signOutButton.click();

        SelenideElement confirmSignOutButton = $(By.xpath("//*[@value=\"Sign out from all accounts\"]"));
        confirmSignOutButton.click();
    }

    @Test
    public void invalidEmailAndPassword(){
        open("https://github.com/login");

        SelenideElement loginInput = $(By.id("login_field"));
        SelenideElement passwordInput = $(By.id("password"));
        SelenideElement submitButton = $(By.name("commit"));

        loginInput.click();
        loginInput.sendKeys("azmat-g");
        passwordInput.click();
        passwordInput.sendKeys("azmat");
        submitButton.click();

        SelenideElement incorrectUsernameMessage = $(By.className("js-flash-alert"));
        incorrectUsernameMessage.shouldBe(visible);
    }
}
