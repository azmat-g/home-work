package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CiCdPage {

    private static final SelenideElement contactSalesButton = $(By.xpath("//a[contains(@href, 'Contact+sales&ref_loc=hero')]"));

    public void openContactSalesPage(){
        contactSalesButton.scrollTo().shouldBe(visible).click();
    }
}
