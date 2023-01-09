import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AmazonTest {
    //=================================================================Amazon test start============
    private final By AMAZON_ACCEPT_COOKIES_BTN = By.id("sp-cc-accept");
    private final By AMAZON_CONTINUE_BTN = By.xpath(".//input[@data-action-type = 'DISMISS']");
    private final By AMAZON_MAIN_MENU_ITEM = By.xpath(".//div[@id = 'nav-xshop']/a");
    private final By AMAZON_LEFT_MENU_ITEM = By.xpath(".//div[@role = 'treeitem']/a");
    private final By AMAZON_BOOK_PAGE_THUMBNAILS = By.xpath(".//div[@class = 'p13n-sc-uncoverable-faceout']/a[1]");
    private final By AMAZON_BOOK_PAGE_THUMBNAIL_STARS = By.xpath(".//span[@class = 'a-icon-alt']");
//    private final By AMAZON_ALL_COMMENTS_BTN = By.xpath(".//*[@id='cr-pagination-footer-0']/a");
    private final By AMAZON_ALL_COMMENTS_BTN = By.xpath(".//a[@data-hook= 'see-all-reviews-link-foot']");
    private final By AMAZON_COMMENT_ITEM = By.xpath(".//div[@class = 'a-section celwidget']");
    private final By AMAZON_COMMENT_NEXT_PAGE_BTN = By.xpath(".//li[@class = 'a-last']/a");

    private WebDriver browser;
    private WebDriverWait wait; //https://www.seleniumeasy.com/selenium-tutorials/webdriver-wait-examples
//https://youtu.be/uWnfiI9CL1g?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=3959 adding list to another list
    //menuItems.addAll(!browser.findElements()) - adding list to another list
//    while (!browser.findElements(NEXT_BTN).isEmpty()) {
// ! - changes logic to while (true) {}
//    !true -> false
//    !false -> true
//    }

    @Test
    public void amazonTest() {
        //Test Data
        String menuItemToSelect = "Best Sellers";
        String menuItemLeft = "Books";
        int bookPositionNumberInTop = 4;

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.amazon.de/");

        wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        closeAllMessages();
        openMenuItem(menuItemToSelect, AMAZON_MAIN_MENU_ITEM);
        openMenuItem(menuItemLeft, AMAZON_LEFT_MENU_ITEM);
        openSpecificItemByNumber(bookPositionNumberInTop, AMAZON_BOOK_PAGE_THUMBNAILS);
        click(AMAZON_ALL_COMMENTS_BTN);


        while (!browser.findElements(AMAZON_COMMENT_NEXT_PAGE_BTN).isEmpty()){
            System.out.println(browser.findElements(AMAZON_COMMENT_ITEM).size());
            click(AMAZON_COMMENT_NEXT_PAGE_BTN);
        }

//        try {
//            browser.findElement(AMAZON_ACCEPT_COOKIES_BTN).click();
//        } catch (NoSuchElementException e) {
//
//        }

    }


    //https://youtu.be/uWnfiI9CL1g?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=3746
    private void openMenuItem(String itemName, By locator) {
        List<WebElement> menuItems = browser.findElements(locator);
//        menuItems - list that we are checking
//        WebElement we - variable where we will store each list variable
        for (WebElement we: menuItems) {
            if (we.getText().equals(itemName)) {
                we.click();
                break;
            }
        }
    }

    private void openSpecificItemByNumber(int bookPositionNumberInTop, By locator) {
      List<WebElement> productItems = browser.findElements(locator);
        productItems.get(bookPositionNumberInTop - 1).click();
//        System.out.println(productItems.size());
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
    private void select(By locator, String value) {
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(we);
        select.selectByValue(value);
    }
//    private void waitForElementsCountToBe(By locator, int count) {
//        wait.until(ExpectedConditions.numberOfElementsToBe(locator, count));
//    }
}
