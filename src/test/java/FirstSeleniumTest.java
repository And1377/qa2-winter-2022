import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FirstSeleniumTest {
    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By LATVIA_COUNTRY_BTN = By.xpath("//a[text()='Latvia']");
    private final By TOP_LOCATION_LINK = By.xpath(".//div[@class = 'tl-box']/a");
    //first page homework---------
    private final By LOGO_BTN_MAIN = By.xpath("//div[@class='logo-cell']");
    private final By CURRENCY_SELECTOR = By.id("currentCurrency");
    private final By LOGIN_BTN = By.className("trigger-login-modal");
    private final By HOME_CAPTION = By.xpath("//div[@class ='home-caption']");
    private final By PICK_UP_DATE_SELECTING = By.xpath(".//div[@class='fake-field clearfix']");
    private final By SEARCH_NOW_BTN = By.id("location-submit");
    private final By COUNTRY_OF_RESIDENCE_LATVIA_BTN = By.id("sb-country");
    private final By CAROUSEL_TESTIMONIALS_ARROWS = By.xpath(".//div[@class = 'svg-slider-arrow']");
    private final By CUSTOMER_TESTIMONIALS = By.xpath(".//div[@id='tp-widget-reviews']/div");
    private final By FIRST_PAGE_H2_HEADINGS = By.xpath(".//div[@class = 'col-12']/h2");
//second page-----------
    private final By CAR_TYPE_FILTER_TOP = By.xpath(".//div[contains(@class, 'car-top-filter-item')]");
    private final By CAR_SELECTION_SLIDER_BTN_RIGHT = By.xpath(".//div[@class = 'car-top-filter-control next']");
    private final By SHOWN_CARS_ON_PAGE = By.xpath(".//span[@class = 'showing-cars']");
    private final By SORT_BY_PRICE_BTN_RIGHT = By.xpath(".//div[@class = 'dc-ui dropdown inline-block']");

    private final By CAR_DESCRIPTION_SECTION_BAG = By.xpath(".//ul[contains(@class, 'dc-list-md text-14')]/li");
    private final By SPECIAL_OFFERS_LEFT_COLUMN = By.xpath(".//div[@class='flt-type'][1]");
    private final By CAR_SPECIFICATIONS_PRICE = By.xpath(".//span[@class = 'min-price']");
    private final By CAR_SPECIFICATIONS_FUEL_TYPE = By.xpath(".//div[@id='filter-fuel-type']/label");
    private final By NUMBER_OF_SEATS = By.xpath(".//div[@id='filter-number-of-seats']/label");

    private final By RENTAL_CONDITIONS = By.xpath(".//a[contains(@class, 'search-index')]");
    private final By RENTAL_VIEW_BTN = By.xpath(".//a[contains(@class, 'btn')]");
    private final By PARTIAL_PREPAYMENT = By.xpath(".//span[contains(@class, 'dc-ui')]");
    private final By CAR_SCORE = By.xpath(".//div[@class = 'supplier-rating']");
//loading page*----------
    private final By LOADING_ANIMATION_CIRCLES = By.xpath(".//*div[contains(@class, 'lds-ellipsis v2')]");
    private final By WE_ARE_CURRENTLY_SEARCHING_TXT = By.xpath("//*[@id='main-wrapper-body']//div[contains(@class, 'mb-8 text-24 text-bold text-center')]");
    private final By FOR_THE_BEST_TXT = By.xpath("//*[@id='main-wrapper-body']//div[contains(@class, 'mb-24 text-center')]");

    @Test
    public void openHomePageCheck() {
        String country = "Latvia";
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser  = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://www.discovercars.com/");

        wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();
        clickOnCountry(country);
        //wait.until(ExpectedConditions.elementToBeClickable(LATVIA_COUNTRY_BTN));
        //browser.findElement(LATVIA_COUNTRY_BTN).click();

    }
    private WebDriver browser;
    private WebDriverWait wait;
    private void clickOnCountry(String country) {
        List<WebElement> links = browser.findElements(TOP_LOCATION_LINK);

        boolean isCountryFound = false;
        for (WebElement link: links) {
            if (link.getText().equals(country)) {
                isCountryFound = true;
                //wait.until(ExpectedConditions.elementToBeClickable(location.findElement((By.tagName("a")))));
                link.click();
                break;
            }
        }

        Assertions.assertTrue(isCountryFound, "Country not Found!");
    }
}
