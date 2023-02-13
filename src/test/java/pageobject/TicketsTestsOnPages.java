package pageobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.model.Passenger;
import pageobject.pages.HomePage;
import pageobject.pages.PassengerInfoPage;

public class TicketsTestsOnPages {
    private final String URL = "qaguru.lv:8089/tickets/";
    private final String FROM_AIRPORT = "RIX";
    private final String TO_AIRPORT = "SFO";
    private BaseFunc baseFunc = new BaseFunc(); //https://youtu.be/4guM0Ij4Yyg?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=2885

    @Test
    public void successfulRegistrationTest() {
        //Passenger passenger = new Passenger("TestName", "TestSurname", "AAAAAAAAA",
                //2, 1, 4, "16-05-2018");

        Passenger passenger = new Passenger("Arturs", "Sivuhins", "MMM", 2,
                2,4, "16-05-2018");

        baseFunc.openUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(FROM_AIRPORT, TO_AIRPORT);

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        //...
        infoPage.fillInPassengerInfo(passenger);

        //https://youtu.be/fm_7RFDKN0k?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=3522

        Assertions.assertEquals(passenger.getFirstName(), infoPage.getPassengerName(), "Wrong name!");
        Assertions.assertEquals(FROM_AIRPORT, infoPage.getFirstFromAirport(), "Error msg!");
        Assertions.assertEquals(FROM_AIRPORT, infoPage.getSecondFromAirport(), "Error msg!");
        Assertions.assertEquals(TO_AIRPORT, infoPage.getFirstToAirport(), "Error msg!");
        Assertions.assertEquals(TO_AIRPORT, infoPage.getSecondToAirport(), "Error msg!");

        //Get List<WebElement> with Name, From Airport, To Airport
        //                            0         1            2
        // .getText() -> String
        // String fromAirport = data.get(1).getText() -> "RIX"
        // Ass.equals(FROM_AIRPORT, fromAirport, "Error message");
        Assertions.assertTrue(infoPage.getPrice().length() > 0, "Error message!");
    }
}
