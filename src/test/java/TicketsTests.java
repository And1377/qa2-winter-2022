import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.BaseFunc;

import java.time.Duration;

public class TicketsTests {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");


    private final By FIRST_NAME = By.id("name");
    private final By LAST_NAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By DISCOUNTS = By.id("adults");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAG = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By DESTANATION_FROM = By.xpath(".//span[@class = 'bTxt'][1]");
    private final By DESTANATION_TO = By.xpath(".//span[@class = 'bTxt'][2]");
    private final By GET_PRICE_BTN = By.xpath(".//div[@id= 'fullForm']/span[8]");
    private final By RESPONSE_TEXT = By.id("response");
    private final By BOOK_BTN = By.id("book2");
    private final By SEAT_ELEMENT = By.cssSelector(".seat");




//    private WebDriver browser;

    private WebDriverWait wait;
    private BaseFunc baseFunc = new BaseFunc();
    @Test
    public void reservationCheck() {
        baseFunc.openUrl("http://www.qaguru.lv:8089/tickets/");

        baseFunc.select(FROM, "RIX");
        baseFunc.select(TO,"SFO");

        baseFunc.click(GO_BTN);
        //Assertions.assertEquals("RIX", DESTANATION_FROM), "not found");

//        Select airportFrom = new Select(browser.findElement(FROM));
//        airportFrom.selectByValue("RIX");
//
//        Select airportTo = new Select(browser.findElement(TO));
//        airportTo.selectByValue("SFO");



        baseFunc.type(FIRST_NAME, "First Name");
        baseFunc.type(LAST_NAME, "Last Name");
        baseFunc.type(DISCOUNT, "Discount Code");
        baseFunc.type(ADULTS, "3");
        baseFunc.type(CHILDREN, "2");
        baseFunc.type(BAG, "1");
        baseFunc.select(FLIGHT, "16");

        //====================  homewok start
        baseFunc.click(GET_PRICE_BTN);
        baseFunc.compare("RIX", DESTANATION_FROM);
        baseFunc.compare("SFO", DESTANATION_TO);
        baseFunc.findElement(RESPONSE_TEXT);
        baseFunc.compare(
                0,
                baseFunc.getValueFromText(RESPONSE_TEXT, "for "," EUR"),
                false
        );
        baseFunc.click(BOOK_BTN);
        baseFunc.compare(
                32,
                baseFunc.findElements(SEAT_ELEMENT).size(),
                true
        );

//        Assertions.assertEquals("RIX", browser.findElement(DESTANATION_FROM).getText());
//        Assertions.assertEquals("SFO", browser.findElement(DESTANATION_TO).getText());
// https://youtu.be/fm_7RFDKN0k?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=2043 working with list items



        //======================homework end

//        browser.findElement(FIRST_NAME).clear();
//        browser.findElement(FIRST_NAME).sendKeys("First Name");
//
//        browser.findElement(LAST_NAME).clear();
//        browser.findElement(LAST_NAME).sendKeys("Last Name");


    }
}
