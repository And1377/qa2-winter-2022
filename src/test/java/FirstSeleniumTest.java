import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstSeleniumTest {
    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    //private final By LATVIA_COUNTRY_BTN = By.xpath("//a[text()='Latvia']");
    //first page homework---------
    private final By LOGO_BTN_MAIN = By.xpath(".//*[contains(@class, 'logo-cell')]");
    private final By CURRENCY_SELECTOR = By.id("currentCurrency");
    private final By LOGIN_BTN = By.className("trigger-login-modal");
    private final By HOME_CAPTION = By.xpath(".//*[contains(@class, 'home-caption')]");
    private final By PICK_UP_DATE_SELECTING = By.xpath(".//*[@id='search-box-form']/div[4]/div");
    private final By SEARCH_NOW_BTN = By.id("location-submit");
    private final By COUNTRY_OF_RESIDENCE_LATVIA_BTN = By.id("sb-country");
    private final By CAROUSEL_TESTIMONIALS_ARROW_LEFT = By.xpath(".//*[@id='review-arrow-left']/div/div");
    private final By WE_COMPARE_PRICES_HEADING = By.xpath(".//h2[text()='We compare car rental prices, you save!']");
//second page-----------
    private final By SMALL_CARS = By.xpath(".//*[contains(@class, 'car-top-filter-box')]/div/div[1]");
    private final By CAR_SELECTION_SLIDER_BTN_RIGHT = By.xpath(".//*[contains(@class, 'car-top-filter-control next')]");
    private final By SHOWN_CARS_ON_PAGE = By.xpath(".//*[contains(@class, 'showing in-list')]/span[1]");
    private final By SORT_BY_PRICE_BTN_RIGHT = By.xpath(".//*[contains(@class, 'dc-ui dropdown-toggle text-blue-500')]");
    private final By CAR_DESCRIPTION_SECTION_BAG = By.xpath("//*[@id='car-box-container']/div[1]//li[2]/span[text()='1 bag']");
    private final By SPECIAL_OFFERS_LEFT_COLUMN = By.xpath(".//div[@class='flt-type'][1]");
    private final By CAR_SPECIFICATIONS_AIR_CONDITIONING_PRICE = By.xpath("//*[@id='filter-air-conditioning']/label/span");
    private final By CAR_SPECIFICATIONS_FUEL_TYPE = By.xpath("//*[@id='filter-fuel-type']/label[2]");
    private final By NUMBER_OF_SEATS = By.xpath("//*[@id='filter-number-of-seats']/label[1]");
    private final By RENTAL_CONDITIONS_FIRST_PANEL = By.xpath("//*[@id='car-box-container']/div[1]//div[contains(@class, 'rc-link')]");
    private final By RENTAL_VIEW_FOR_FIRST_PANEL = By.xpath("//*[@id='car-box-container']/div[1]//a[contains(@class, 'btn btn-book submit click-on-car selected-car prevent-loading instant')]");
    private final By PARTIAL_PREPAYMENT = By.xpath(".//*[contains(@class, 'dc-ui badge badge-medium badge-blue')]");
    private final By CAR_SCORE_FOR_SECOND_PANEL_BOX = By.xpath("//*[@id='car-box-container']/div[2]//div[contains(@class, 'supplier-rating')]");


    @Test
    public void openHomePageCheck() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver browser  = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://www.discovercars.com/");

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();
        //wait.until(ExpectedConditions.elementToBeClickable(LATVIA_COUNTRY_BTN);
        //browser.findElement(LATVIA_COUNTRY_BTN).click();
    }
}
