package api.services;

import api.ParamNames;
import api.dto.request.user.CreateUser;
import api.dto.response.User;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;

public class UserApiService extends BaseRestClient {

    private static final String POST_USER = "/user";
    private static final String GET_USER = "/user/{userName}";

    @Override
    public RequestSpecification jsonRequest() {
        return super.jsonRequest();
    }

    public CreateUser createUser(User user) {
        return jsonRequest().body(user)
                .expect().statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/createUser.json"))
                .log().all()
                .when().post(POST_USER)
                .as(CreateUser.class);
    }

    public User getUser(String nameUser) {
        return jsonRequest()
                .pathParams(ParamNames.USER_NAME, nameUser)
                .expect().statusCode(200)
                .log().all()
                .when().get(GET_USER)
                .as(User.class);
    }

}
