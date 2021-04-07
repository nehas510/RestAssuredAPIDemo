import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RestAPITest {

@Test
    public void tryLoginTest() {
    RestAssured.baseURI = "http://localhost:3001";
    Response res = given().header("Content-Type","application/json")
            .body("{\n" +
                    "    \"username\": \"wjeir\",\n" +
                    "    \"password\": \"wer\"\n" +
                    "}")
            .when().post("/login")
            .then().assertThat().statusCode(200).extract().response();

}


@Test
    public void loginDemoTest(){
    RestAssured.baseURI = "http://localhost:3001";
    Response res = given().header("Content-Type","application/json")
            .body("{\n" +
                    "    \"username\": \"tryiuroi\",\n" +
                    "    \"password\": \"ndeojo\"\n" +
                    "}")
            .when().post("/login")
            .then().assertThat().statusCode(200).extract().response();
    System.out.println(res.getBody().print());
}






}
