package pageobject.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import pageobject.BaseFunc;
import pageobject.model.FlightInfo;
import pageobject.model.Passenger;

//https://youtu.be/fm_7RFDKN0k?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=577

public class PassengerInfoPage {
    private final By FIRST_NAME = By.id("name");
    private final By LAST_NAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAG = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By GET_PRICE_LINK = By.xpath(".//span[@onclick = 'setLang();']");

    private final By RESERVATION_INFO = By.xpath(".//span[@class = 'bTxt']");
    private final By RESPONSE_BLOCK = By.id("response");

    private BaseFunc baseFunc;

    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillInPassengerInfo(FlightInfo info) {
        baseFunc.type(FIRST_NAME, info.getPassenger().getFirstName());
        baseFunc.type(LAST_NAME, info.getPassenger().getLastName());
        baseFunc.type(DISCOUNT, info.getDiscount());
        baseFunc.type(ADULTS, info.getAdultsCount());
        baseFunc.type(CHILDREN, info.getChildCount());
        baseFunc.type(BAG, info.getBagsCount());
        baseFunc.selectByText(FLIGHT, info.getFlightDate());

        baseFunc.click(GET_PRICE_LINK);
        baseFunc.waitForElementsCountToBe(RESERVATION_INFO, 5);
    }

    public String getFirstFromAirport() {
        return baseFunc.findElements(RESERVATION_INFO).get(0).getText();
    }

    public String getFirstToAirport() {
        return baseFunc.findElements(RESERVATION_INFO).get(1).getText();
    }

    public String getSecondFromAirport() {
        return baseFunc.findElements(RESERVATION_INFO).get(3).getText();
    }

    public String getSecondToAirport() {
        return baseFunc.findElements(RESERVATION_INFO).get(4).getText();
    }

    public String getPassengerName() {
        String name = baseFunc.findElements(RESERVATION_INFO).get(2).getText(); //Dima!
        return name.substring(0, name.length() - 1);
    }

    public String getPrice() {
        String text = baseFunc.findElement(RESPONSE_BLOCK).getText();
        return StringUtils.substringBetween(text, "for ", " EUR");
    }
}
