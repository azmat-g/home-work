package tests.github;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ValidationTest {

    @Test
    public void invalidEmailTest(){
        open("https://github.com/signup?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home");

        SelenideElement emailInput = $(By.name("user[email]"));
        SelenideElement continueButton = $(By.xpath("//*[@data-continue-to=\"password-container\"]"));

        emailInput.click();
        emailInput.sendKeys("azmatgmail.com");
        continueButton.shouldNotBe(clickable);
    }

    @Test
    public void validEmailTest(){
        open("https://github.com/signup?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home");
        SelenideElement emailInput = $(By.name("user[email]"));
        SelenideElement continueButton = $(By.xpath("//*[@data-continue-to=\"password-container\"]"));

        emailInput.clear();
        emailInput.sendKeys("azmat2000@gmail.com");
        continueButton.shouldBe(clickable);
    }
}
