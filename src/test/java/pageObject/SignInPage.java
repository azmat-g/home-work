package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {
    private static final String pageUrl = "/login";

    private static final SelenideElement loginInput = $(By.id("login_field"));
    private static final SelenideElement passwordInput = $(By.id("password"));
    private static final SelenideElement submitButton = $(By.name("commit"));

    public String getPageUrl(){
        return pageUrl;
    }

    public void setEmail(String email){
        loginInput.shouldBe(visible).setValue(email);
    }

    public void setPassword(String password){
        passwordInput.shouldBe(visible).setValue(password);
    }

    public void pushSubmitButton(){
        submitButton.shouldBe(visible).click();
    }

    public void isSubmitButtonDisplayed(){
        submitButton.shouldBe(visible);
    }

    public void authOperation(String email, String password){
        setEmail(email);
        setPassword(password);
        pushSubmitButton();
    }
}
