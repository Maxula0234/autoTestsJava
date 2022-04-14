package api.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseRestClient {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    public RequestSpecification jsonRequest() {
        requestSpecification = RestAssured.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .log().all();
        responseSpecification = requestSpecification.expect().statusCode(200)
                .log().all();
        return requestSpecification;
    }

    public ResponseSpecification getResponseSpecification() {
        return responseSpecification;
    }
}
