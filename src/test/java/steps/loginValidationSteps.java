package steps;

import data.login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.runner.RunWith;
import resource.Utils;

import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
public class loginValidationSteps extends Utils {

    RequestSpecification res;
    Response loginresponse;
    private JsonPath jsResp;
    private JSONObject requestParam;

    @Given("^Login API with (.+) and (.+)$")
    public void login_api_with_and(String username, String password) throws Throwable {
        requestParam = new JSONObject();
        requestParam.put("username",username);
        requestParam.put("password",password);

        res = given().spec(requestSpecification())
                .body(requestParam.toJSONString());


    }

    @Given("^LoginAPI with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginapi_with(String strArg1, String strArg2) throws Throwable {
        requestParam = new JSONObject();
        requestParam.put("username",strArg1);
        requestParam.put("password",strArg2);

        res = given().spec(requestSpecification())
                .body(requestParam.toJSONString());


    }

    @When("^requests login$")
    public void requests_login() throws Throwable {
        loginresponse = res.when().post("/login");
    }

    @Then("^is sucessfully logged in with status code \"([^\"]*)\"$")
    public void is_sucessfully_logged_in_with_status_code(String strArg1) throws Throwable {
        loginresponse.then().assertThat().statusCode(Integer.parseInt(strArg1)).extract().response();
    }

    @Then("^gets an error with status code \"([^\"]*)\"$")
    public void gets_an_error_with_status_code(String strArg1) throws Throwable {
        loginresponse.then().assertThat().statusCode(Integer.parseInt(strArg1));
    }

    @And("^sessionToken is \"([^\"]*)\"$")
    public void sessiontoken_is(String strArg1) throws Throwable {

        jsResp = loginresponse.jsonPath();
        System.out.println("The session token is: " + jsResp.get("sessionToken"));
        Assert.assertEquals(strArg1,jsResp.get("sessionToken"));


    }


    @And("^\"([^\"]*)\" is \"([^\"]*)\"$")
    public void error_is(String strArg1, String strArg2) throws Throwable {
        jsResp = loginresponse.jsonPath();
        System.out.println(jsResp.get(strArg1));
        Assert.assertEquals(strArg2,jsResp.get(strArg1));
    }


}