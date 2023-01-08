import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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




    private WebDriver browser;
    private WebDriverWait wait;

    @Test
    public void reservationCheck() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://www.qaguru.lv:8089/tickets/");

        wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        select(FROM, "RIX");
        select(TO,"SFO");

        browser.findElement(GO_BTN).click();
        //Assertions.assertEquals("RIX", DESTANATION_FROM), "not found");

//        Select airportFrom = new Select(browser.findElement(FROM));
//        airportFrom.selectByValue("RIX");
//
//        Select airportTo = new Select(browser.findElement(TO));
//        airportTo.selectByValue("SFO");



        type(FIRST_NAME, "First Name");
        type(LAST_NAME, "Last Name");
        type(DISCOUNT, "Discount Code");
        type(ADULTS, "3");
        type(CHILDREN, "2");
        type(BAG, "1");
        select(FLIGHT, "16");

        //====================  homewok start
        browser.findElement(GET_PRICE_BTN).click();
        compare("RIX", DESTANATION_FROM);
        compare("SFO", DESTANATION_TO);
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
    private  void select(By locator, String value) {
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(we);
        select.selectByValue(value);
    }


    private void type(By locator, String text) {
    WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    input.clear();
    input.sendKeys(text);
    }

    private void compare(String text, By locator) {
        Assertions.assertEquals(text, browser.findElement(locator).getText());
    }
    
}
