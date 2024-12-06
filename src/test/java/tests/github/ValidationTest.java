package tests.github;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageObject.SignUpPage;
import uiConfiguration.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ValidationTest extends BaseTest {

    @BeforeEach
    public void openPage(){
        open(new SignUpPage().getPageUrl());
        new SignUpPage().isContinueBtnDisplayed();
    }

    @Test
    public void invalidEmailTest(){
        SignUpPage signUpPage = new SignUpPage();
        open(signUpPage.getPageUrl());
        signUpPage.setEmail("azmatgmail.com");
        signUpPage.getContinueButton().shouldNotBe(clickable);
    }

    @Test
    public void validEmailTest(){
        SignUpPage signUpPage = new SignUpPage();
        open(signUpPage.getPageUrl());
        signUpPage.setEmail("azmat2000@gmail.com");
        signUpPage.getContinueButton().shouldBe(clickable);
    }
}
