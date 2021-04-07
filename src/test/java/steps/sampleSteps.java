package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
public class sampleSteps {
    RequestSpecification request = new RequestSpecBuilder().setBaseUri("http://localhost:3001")
            .setContentType(ContentType.JSON).build();
    RequestSpecification res;
    Response response;

        @Given("^LoginAPI have \"([^\"]*)\" and \"([^\"]*)\"$")
        public void loginapi_have_something_and_something(String strArg1, String strArg2) throws Throwable {
             res = given().spec(request)
                    .body("{\n" +
                            "    \"username\": \"wjeir\",\n" +
                            "    \"password\": \"wer\"\n" +
                            "}");
        }

        @When("^requesting login$")
        public void requesting_login() throws Throwable {
             response = res.when().post("/login");
        }
    @Then("^is logged in with status code \"([^\"]*)\"$")
    public void is_logged_in_with_status_code_something(String strArg1) throws Throwable {
        response.then().assertThat().statusCode(200);
    }


    }

