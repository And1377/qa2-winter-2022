import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.BaseFunc;

import java.time.Duration;
import java.util.List;

public class AmazonTest {
    //=================================================================Amazon test start============
    private final By AMAZON_ACCEPT_COOKIES_BTN = By.id("sp-cc-accept");
    private final By AMAZON_CONTINUE_BTN = By.xpath(".//input[@data-action-type = 'DISMISS']");
    private final By AMAZON_MAIN_MENU_ITEM = By.xpath(".//div[@id = 'nav-xshop']/a");
    private final By AMAZON_LEFT_MENU_ITEM = By.xpath(".//div[@role = 'treeitem']/a");
    private final By AMAZON_BOOK_PAGE_THUMBNAILS = By.xpath(".//div[@class = 'p13n-sc-uncoverable-faceout']/a[1]");
    private final By AMAZON_ALL_COMMENTS_BTN = By.xpath(".//a[@data-hook= 'see-all-reviews-link-foot']");
    private final By AMAZON_COMMENT_ITEM = By.xpath(".//div[@class = 'a-section celwidget']");
    private final By AMAZON_COMMENT_NEXT_PAGE_BTN = By.xpath(".//li[@class = 'a-last']/a");
    private final By AMAZON_BEST_SELLER_SECTION_STAR_AMOUNT = By.xpath(".//span[@class = 'a-icon-alt']");
    private final By AMAZON_TOTAL_REVIEWS_COUNT = By.xpath(".//div[@data-hook='cr-filter-info-review-rating-count']");

    private WebDriver browser;
    private WebDriverWait wait;

    //https://www.seleniumeasy.com/selenium-tutorials/webdriver-wait-examples
//https://youtu.be/uWnfiI9CL1g?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=3959 adding list to another list
    //menuItems.addAll(!browser.findElements()) - adding list to another list
//    while (!browser.findElements(NEXT_BTN).isEmpty()) {
// ! - changes logic to while (true) {}
//    !true -> false
//    !false -> true
//    }

    @Test
    public void amazonTest() {
        String menuItemToSelect = "Best Sellers";
        String menuItemLeft = "Books";
        int bookPositionNumberInTop = 3;
        int commentCountAllPages = 0;


        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.amazon.de/");

        wait = new WebDriverWait(browser, Duration.ofSeconds(2));

        closeAllMessages();
        openMenuItem(menuItemToSelect, AMAZON_MAIN_MENU_ITEM);
        openMenuItem(menuItemLeft, AMAZON_LEFT_MENU_ITEM);
        String itemStarScore = browser.findElements(AMAZON_BEST_SELLER_SECTION_STAR_AMOUNT).
                get(bookPositionNumberInTop - 1).getAttribute("textContent").substring(0, 3);
        openSpecificItemByNumber(bookPositionNumberInTop, AMAZON_BOOK_PAGE_THUMBNAILS);
        String starsInDescription = browser.findElement(AMAZON_BEST_SELLER_SECTION_STAR_AMOUNT).
                getAttribute("textContent").substring(0, 3);
        Assertions.assertEquals(itemStarScore, starsInDescription, "Star amount doesn't matches!");

        //https://youtu.be/wg0w5l-Snrw?t=4342 -- wait and Thread sleep
        //https://youtu.be/uWnfiI9CL1g?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=1519 -- get element value

        click(AMAZON_ALL_COMMENTS_BTN);
        getReviewCount();
        while (isPaginationActive()) {
            List<WebElement> existingElements = browser.findElements(AMAZON_COMMENT_ITEM);
            commentCountAllPages += existingElements.size();
            //https://www.w3docs.com/snippets/java/stale-element-reference-element-is-not-attached-to-the-page-document.html
            //
            //System.out.println(commentCountAllPages);
            try {
                click(AMAZON_COMMENT_NEXT_PAGE_BTN);
            } catch (WebDriverException e) {
                if (e.getClass().equals(StaleElementReferenceException.class)) {
                    click(AMAZON_COMMENT_NEXT_PAGE_BTN);
                } else {
                    System.out.println("Exception was something other than Stale element");
                }
            }
            wait.until(ExpectedConditions.invisibilityOf(existingElements.get(0)));
        }
        commentCountAllPages += browser.findElements(AMAZON_COMMENT_ITEM).size();
        System.out.println("Amount of counted comments is: " + commentCountAllPages);
        System.out.println("Amount of comments in description: " + getReviewCount());
        Assertions.assertEquals(getReviewCount(), commentCountAllPages, "Error- values not equal");
    }

    //
//    https://youtu.be/uWnfiI9CL1g?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=3746
    private void openMenuItem(String itemName, By locator) {
        List<WebElement> menuItems = browser.findElements(locator);
        for (WebElement we : menuItems) {
            if (we.getText().equals(itemName)) {
                we.click();
                break;
            }
        }
    }

    //https://youtu.be/fm_7RFDKN0k?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=4199 extract value from string
    //

    private void openSpecificItemByNumber(int bookPositionNumberInTop, By locator) {
        List<WebElement> productItems = browser.findElements(locator);
        productItems.get(bookPositionNumberInTop - 1).click();
    }

    private void closeAllMessages() {
        wait.until(ExpectedConditions.elementToBeClickable(AMAZON_ACCEPT_COOKIES_BTN)); //https://habr.com/ru/post/443754/
        browser.findElement(AMAZON_ACCEPT_COOKIES_BTN).click();

        wait.until(ExpectedConditions.elementToBeClickable(AMAZON_CONTINUE_BTN));
        browser.findElement(AMAZON_CONTINUE_BTN).click();
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private boolean isPaginationActive() {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(AMAZON_COMMENT_ITEM, 10));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    private WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private int getReviewCount() {
        String text = findElement(AMAZON_TOTAL_REVIEWS_COUNT).getText();
        return Integer.parseInt(StringUtils.substringBetween(text, "ratings, ", " with"));
    }

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }
}
