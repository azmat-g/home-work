package tests.petStore;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import tests.petStore.pojos.*;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetTests {

    @Test
    @Order(1)
    public void createPet(){

        PetFull petRequestBody = PetFull.getPetData();

        PetFull petResponseBody = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .contentType(ContentType.JSON)
                .body(petRequestBody)
                .when().post()
                .then().statusCode(200)
                .extract()
                .as(PetFull.class);

        assertThat(petResponseBody).isNotNull();
        assertThat(petResponseBody).isEqualTo(petRequestBody);
    }

    @Test
    @Order(2)
    public void findPetById(){
        int petId = 357;

        PetFull petResponseBody = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/" + petId)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().as(PetFull.class);

        assertThat(petResponseBody).isNotNull();
        assertThat(petResponseBody.getId()).isEqualTo(petId);
    }

    @Test
    @Order(3)
    public void deletePet(){
        String petId = "357";

        Response deleteResponse = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/" + petId)
                .contentType(ContentType.JSON)
                .when().delete()
                .then().statusCode(200)
                .extract().as(Response.class);

        assertThat(deleteResponse).isNotNull();
        assertThat(deleteResponse.getMessage()).isEqualTo(petId);
    }

    @Test
    @Order(4)
    public void invalidRequest(){
        InvalidPetBody invalidPetBody = InvalidPetBody.getInvalidPetData();
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .contentType(ContentType.JSON)
                .body(invalidPetBody)
                .when().post()
                .then().statusCode(500)
                .extract()
                .as(Response.class);

        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("something bad happened");
    }
}