package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response; //null

    @Given("city ID is: {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;

    }

    @When("we are requesting weather forecast")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        requester.requestWeather(cityId);
    }

    @Then("coordinates are:")
    public void Check_coordinates(Map<String, Double> params) {
        Assertions.assertEquals(params.get("latitude"), response.getLat(), "wrong lat!");
        Assertions.assertEquals(params.get("latitude"), response.getLon(), "wrong lon!");

    }

    @Then("timezone infofmation is:")
    public void check_timezone(Map<String, String> params) {


    }

    @Then("current weather data is:")
    public void check_current_weather(Map<String, String> params) {

    }

    @Then("alert Nr. {int} reicived:")
    public void check_alert(int index, Map<String, String> params) {

    }
}
