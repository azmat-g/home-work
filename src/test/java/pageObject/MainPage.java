package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private static final SelenideElement solutionsButton = $(By.xpath("//button[contains(text(),'Solutions')]"));
    private static final SelenideElement ciCdButton = $(By.xpath("//a[contains(text(),'CI/CD')]"));

    public void openCiCdPage(){
        solutionsButton.shouldBe(visible).click();
        ciCdButton.shouldBe(visible).click();
    }
}
