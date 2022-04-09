package api.services;

import api.dto.CreateUser;
import api.dto.User;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserApiService {

    private final String BASE_URL = "https://petstore.swagger.io/v2";
    private final String ENDPOINT_PATH = "/user";
    RequestSpecification requestSpecification;

    public UserApiService() {
        requestSpecification = given().baseUri(BASE_URL).contentType(ContentType.JSON);
    }

    public CreateUser createUser(User user) {
        return requestSpecification.body(user)
                .log().all()
                .expect().statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/createUser.json"))
                .when().post(ENDPOINT_PATH)
                .as(CreateUser.class);
    }

}
