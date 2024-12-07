package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContactSalesPage {

    private static final SelenideElement firstNameInput = $(By.id(":Rimb:"));
    private static final SelenideElement lastNameInput = $(By.id(":R12mb:"));

    public void setFirstNameAndLastName(String firstName, String lastName){
        firstNameInput.shouldBe(visible).sendKeys(firstName);
        lastNameInput.shouldBe(visible).sendKeys(lastName);
    }

    public SelenideElement getFirstNameInput(){
        return firstNameInput;
    }

    public SelenideElement getLastNameInput(){
        return lastNameInput;
    }
}
