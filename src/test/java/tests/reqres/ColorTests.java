package tests.reqres;

import com.codeborne.selenide.collections.SizeLessThanOrEqual;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import tests.reqres.pojos.ColorPojo;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsEqual.equalTo;

public class ColorTests {

    @Test
    public void getColors(){
         given()
                .baseUri("https://reqres.in/api")
                .basePath("/unknown")
                .queryParam("per_page", 12)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                 .assertThat().body("data.year", everyItem(greaterThanOrEqualTo(2000)));
    }
}
