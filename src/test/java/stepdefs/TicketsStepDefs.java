package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Reservation;
import org.junit.jupiter.api.Assertions;
import pageobject.BaseFunc;
import pageobject.model.FlightInfo;
import pageobject.model.Passenger;
import pageobject.pages.HomePage;
import pageobject.pages.PassengerInfoPage;
import requesters.TicketsRequester;

import java.util.List;
import java.util.Map;

public class TicketsStepDefs {
    private FlightInfo flightInfo; //null
    private HomePage homePage; //null
    private PassengerInfoPage infoPage; //null
    private List<Reservation> reservations;
    private Reservation reservationFromApi; //null
    private BaseFunc baseFunc = new BaseFunc();

    private final String URL = "qaguru.lv:8089/tickets/";

    @Given("flight info:")
    public void set_flight_info(Map<String,String> params) {
        flightInfo = new FlightInfo(params.get("destination"), params.get("departure"), params.get("discount"),
                Integer.parseInt(params.get("adults")), Integer.parseInt(params.get("kids")),
                Integer.parseInt(params.get("bags")), params.get("flight_date"), Integer.parseInt(params.get("seat")));

    }
    @Given("passenger info is:")
    public void set_passenger_info(Map<String, String> params) {
        Passenger passenger = new Passenger(params.get("first_name"), params.get("last_name"));
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

    @When("we press go go go button")
//    public void click_gogogo_btn() {
//        baseFunc.click();
//    }

    @When("we are filling in apassanger registration form")
    public void fill_in_passenger_form() {

        infoPage.fillInPassengerInfo(flightInfo);
    }

    @When("we are requesting reservations data")
    public void request_reservations() throws JsonProcessingException {
        TicketsRequester requester = new TicketsRequester();
        reservations = requester.getReservations();
    }

    @Then("current reservation is in the list")
    public void find_reservation() {
     for (Reservation r : reservations) {
        if (r.getName().equals(flightInfo.getPassenger().getFirstName())) {
          reservationFromApi = r;
          break;
        }
     }
     Assertions.assertNotNull(reservationFromApi, "reservation isn't found");
    }

    @Then("all reservation data is correct")
    public void check_reservation_data() {
 //reservation From Api is used here for assertion
    }
}
