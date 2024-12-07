package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private static final SelenideElement avatar = $(By.xpath("//*[@class=\"avatar circle\"]"));
    private static final SelenideElement signOutButton = $(By.id(":r12:--label"));
    private static final SelenideElement confirmSignOutButton = $(By.xpath("//*[@value=\"Sign out from all accounts\"]"));

    public SelenideElement getAvatar(){
        return avatar;
    }

    public void logOut(){
        avatar.shouldBe(visible).click();
        signOutButton.shouldBe(visible).click();
        confirmSignOutButton.shouldBe(visible).click();
    }

}
