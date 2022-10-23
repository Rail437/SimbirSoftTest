package testapi.test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseTest {
    public final String TOKEN = "y0_AgAAAABlihGjAADLWwAAAADSEFIrUKk3-3LiTV-UUcmsYe22gNtRruk";
    public final String BASE_URI = "https://cloud-api.yandex.net/v1/disk/resources";

    public String folder;

    RequestSpecification requestSpec;

    @BeforeTest
    public void beforeTest(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("Authorization", TOKEN)
                .setAccept(ContentType.JSON)
                .build();
    }

    public void folderCreation(String folderName){
        given()
                .spec(requestSpec)
                .param("path", folderName)
                .when()
                .put()
                .then()
                .statusCode(201);
    }

    public void folderCheck(String folderName){
        given()
                .spec(requestSpec)
                .param("path", folderName)
                .when()
                .get()
                .then()
                .statusCode(200);
    }


    @AfterTest
    public void afterTest(){
        given()
                .spec(requestSpec)
                .param("path", folder)
                .when()
                .delete()
                .then()
                .statusCode(204);
    }


}
