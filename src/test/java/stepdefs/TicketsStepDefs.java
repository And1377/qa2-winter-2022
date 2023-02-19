package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageobject.BaseFunc;
import pageobject.model.FlightInfo;
import pageobject.model.Passenger;
import pageobject.pages.HomePage;
import pageobject.pages.PassengerInfoPage;

import java.util.Map;

public class TicketsStepDefs {
    private FlightInfo flightInfo; //null
    private HomePage homePage; //null
    private PassengerInfoPage infoPage; //null
    private BaseFunc baseFunc = new BaseFunc();

    private final String URL = "qaguru.lv:8089/tickets/";

    @Given("flight info:")
    public void set_flight_info(Map<String,String> params) {
        flightInfo = new FlightInfo(params.get("destination"), params.get("departure"), params.get("discount"),
                Integer.parseInt(params.get("adults")), Integer.parseInt(params.get("kids")),
                Integer.parseInt(params.get("bags")), params.get("flight_date"), Integer.parseInt(params.get("seat")));

    }
    @Given("passanger info is:")
    public void set_passenger_info(Map<String, String> params) {
        Passenger passenger = new Passenger(params.get("first_NAME"), params.get("last_name"));
        flightInfo.setPassenger(passenger);
    }

    @Given("home page opened")
    public void open_home_page() {
        baseFunc.openUrl(URL);
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void select_airports() {
        homePage.selectAirports(flightInfo.getDeparture(),flightInfo.getDestanation());
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @Then("selected airports appears on the next page")
    public void check_airports() {
        Assertions.assertEquals(flightInfo.getDeparture(), infoPage.getFirstFromAirport(), "Error msg!");
        Assertions.assertEquals(flightInfo.getDestanation(), infoPage.getSecondToAirport(), "Error msg!");
    }
}
