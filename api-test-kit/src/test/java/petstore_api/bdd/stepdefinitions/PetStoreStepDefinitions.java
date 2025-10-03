package petstore_api.bdd.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class PetStoreStepDefinitions {

    private final PetStoreSteps petStoreSteps = new PetStoreSteps();

    @Given("the base URI is {string}")
    public void theBaseURIIs(String baseURI) {
        petStoreSteps.setBaseURI(baseURI);
    }

    @Given("the endpoint is {string}")
    public void theEndpointIs(String endpoint) {
        petStoreSteps.setEndpoint(endpoint);
    }

    @Given("the request method is {string}")
    public void theRequestMethodIs(String method) {
        petStoreSteps.setRequestMethod(method);
    }

    @Given("the query parameter {string} is {string}")
    public void theQueryParameterIs(String key, String value) {
        petStoreSteps.setQueryParam(key, value);
    }

    @Given("the request body is:")
    public void theRequestBodyIs(String body) {
        petStoreSteps.setRequestBody(body);
    }

    @Given("the path parameter {string} is {string}")
    public void thePathParameterIs(String key, String value) {
        petStoreSteps.setPathParam(key, value);
    }

    @When("the request is sent")
    public void theRequestIsSent() {
        petStoreSteps.sendRequest();
    }

    @Then("the status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        petStoreSteps.verifyStatusCode(statusCode);
    }

    @Then("the content type is {string}")
    public void theContentTypeIs(String contentType) {
        petStoreSteps.verifyContentType(contentType);
    }

    @Then("the response is not empty")
    public void theResponseIsNotEmpty() {
        petStoreSteps.verifyResponseNotEmpty();
    }

    @Then("the field {string} is {string}")
    public void theFieldIs(String field, String expectedValue) {
        petStoreSteps.verifyResponseField(field, expectedValue);
    }
}