package pageobject;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.model.FlightInfo;
import pageobject.model.Passenger;
import pageobject.pages.HomePage;
import pageobject.pages.PassengerInfoPage;

public class TicketsTestsOnPages {
    private final String URL = "qaguru.lv:8089/tickets/";
//    private final String FROM_AIRPORT = "RIX";
//    private final String TO_AIRPORT = "SFO";
    private BaseFunc baseFunc = new BaseFunc(); //https://youtu.be/4guM0Ij4Yyg?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=2885

    @Test
    public void successfulRegistrationTest() {
        //Passenger passenger = new Passenger("TestName", "TestSurname", "AAAAAAAAA",
                //2, 1, 4, "16-05-2018");

        Passenger passenger = new Passenger("Arturs", "Sivuhins");
int seatNr = RandomUtils.nextInt(1,35);
        FlightInfo info = new FlightInfo("SFO", "RIX", "CCCCCC",2,1,
                4,"16-05-2018", seatNr);
        info.setPassenger(passenger);

        baseFunc.openUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
       // homePage.selectAirports(FROM_AIRPORT, TO_AIRPORT);
        homePage.selectAirports(info.getDeparture(), info.getDestanation());

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        //...
        infoPage.fillInPassengerInfo(info);

        //https://youtu.be/fm_7RFDKN0k?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=3522

        Assertions.assertEquals(passenger.getFirstName(), infoPage.getPassengerName(), "Wrong name!");
        Assertions.assertEquals(info.getDeparture(), infoPage.getFirstFromAirport(), "Error msg!");
        Assertions.assertEquals(info.getDeparture(), infoPage.getSecondFromAirport(), "Error msg!");
        Assertions.assertEquals(info.getDestanation(), infoPage.getFirstToAirport(), "Error msg!");
        Assertions.assertEquals(info.getDestanation(), infoPage.getSecondToAirport(), "Error msg!");

        //Get List<WebElement> with Name, From Airport, To Airport
        //                            0         1            2
        // .getText() -> String
        // String fromAirport = data.get(1).getText() -> "RIX"
        // Ass.equals(FROM_AIRPORT, fromAirport, "Error message");
        Assertions.assertTrue(infoPage.getPrice().length() > 0, "Error message!");
    }
}
