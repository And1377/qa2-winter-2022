package pageobject.pages;

import org.openqa.selenium.By;
import pageobject.BaseFunc;
import pageobject.model.Passenger;

public class PassangerInfoPage {
    private BaseFunc baseFunc;
    private final By FIRST_NAME = By.id("name");
    private final By LAST_NAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By DISCOUNTS = By.id("adults");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAG = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By GET_PRICE_LINK = By.xpath(".//span[@onclick = 'setLang();']");
    public PassangerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
    public void fillInPassangerInfo(Passenger passenger) {
baseFunc.type(FIRST_NAME, passenger.getFirstName());
baseFunc.type(LAST_NAME, passenger.getLastName());
baseFunc.type(DISCOUNT, passenger.getDiscount());
    }
}
