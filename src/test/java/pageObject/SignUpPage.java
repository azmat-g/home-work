package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {
    private static final String pageUrl = "/signup?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home";
    private static final SelenideElement emailInput = $(By.name("user[email]"));
    private static final SelenideElement continueButton = $(By.xpath("//*[@data-continue-to=\"password-container\"]"));

    public void setEmail(String email){
        emailInput.shouldBe(visible).setValue(email);
    }

    public void isContinueBtnDisplayed(){
        continueButton.shouldBe(visible);
    }

    public String getPageUrl(){
        return pageUrl;
    }

    public SelenideElement getContinueButton(){
        return continueButton;
    }
}
