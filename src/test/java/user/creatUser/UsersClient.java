package user.creatUser;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import user.creatUser.Response.CreateUserResponse;
import user.creatUser.Response.ErrorResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public CreateUserResponse getAuthorization(CreateRequestBody requestBody) {

        Response response = create(requestBody);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);

        createUserResponse.setStatusCode(response.statusCode());

        return createUserResponse;
    }


    public Response create(CreateRequestBody requestBody) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer 2d44b11e73ef7aa18da94b6236e86a8b6f1ad4d951b501dc73ba88ef9e9baf86")
                .body(requestBody)
                .when()
                .post("https://gorest.co.in/public/v1/users");

        response.then()
                .log().body();

        return
                response;
    }

    public Response getAllUser() {
        return given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
    }


    public ErrorResponse createUserErrorResponse(CreateRequestBody body){
        Response response = create(body);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);
        errorResponse.setStatusCode(response.getStatusCode());
        return errorResponse;
    }





}
