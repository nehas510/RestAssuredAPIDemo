import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SpecBuilderTest {
    RequestSpecification request = new RequestSpecBuilder().setBaseUri("http://localhost:3001")
            .setContentType(ContentType.JSON).build();


    @Test
    public void tryLoginTest11() {

        RequestSpecification res = given().spec(request)
                .body("{\n" +
                        "    \"username\": \"wjeir\",\n" +
                        "    \"password\": \"wer\"\n" +
                        "}");


        Response response = res.when().post("/login");

                response.then().assertThat().statusCode(200);

    }

    @Test
    public void getAllUsers(){

        RequestSpecification res = given().spec(request);
        Response response = res.when().get("/users");
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getUserById(){

        RequestSpecification res = given().spec(request).pathParam("userid","jowo");

        Response response = res.when().get("/users/{userid}");
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getUserByName(){

        RequestSpecification res = given().spec(request).queryParam("name","John");
        Response response = res.when().get("/users");
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void putUsersById(){

        RequestSpecification res = given().spec(request).pathParam("userid","John");
        Response response = res.when().put("/users/{userid}");
        response.then().assertThat().statusCode(202);

    }

    @Test
    public void deleteUsersById(){

        RequestSpecification res = given().spec(request).pathParam("userid","1");
        Response response = res.when().delete("/users/{userid}");
        response.then().assertThat().statusCode(204);

    }
}
