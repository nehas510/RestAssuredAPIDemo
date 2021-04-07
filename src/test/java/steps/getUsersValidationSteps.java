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
import resource.Utils;

import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
public class getUsersValidationSteps extends Utils {

    RequestSpecification res;
    Response response;

    @Given("^Users API$")
    public void users_api() throws Throwable {
        res = given().spec(requestSpecification());
    }

    @Given("^Users API by name \"([^\"]*)\"$")
    public void users_api_by_name(String strArg1) throws Throwable {
        res = given().spec(requestSpecification()).queryParam("userid",strArg1);
    }

    @Given("^Delete API with  \"([^\"]*)\"$")
    public void delete_api_with_id(String strArg1) throws Throwable {
        res = given().spec(requestSpecification());
    }

    @When("^calling the users api$")
    public void calling_the_users_api() throws Throwable {
        response = res.when().get("/users");
    }

    @When("^calling the users api by path id \"([^\"]*)\"$")
    public void calling_the_users_api_by_path_id(String strArg1) throws Throwable {
        response = res.when().get("/users/"+ strArg1);
    }


    @When("^calling the users api by id \"([^\"]*)\"$")
    public void calling_the_users_api_by_id(String strArg1) throws Throwable {
     response = res.when().put("/users/"+ strArg1);
    }

    @When("^calling the delete api with \"([^\"]*)\"$")
    public void calling_the_delete_api_with_a_userid(String strArg1) throws Throwable {
        response = res.when().delete("/users/" + strArg1);
    }

    @Then("^get response with status code \"([^\"]*)\"$")
    public void get_response_with_status_code(String strArg1) throws Throwable {
        response.then().assertThat().statusCode(Integer.parseInt(strArg1));

    }

}