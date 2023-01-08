import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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


        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.amazon.de/");

        wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        closeAllMessages();
        openMenuItem(menuItemToSelect);

        try {
            browser.findElement(AMAZON_ACCEPT_COOKIES_BTN).click();
        } catch (NoSuchElementException e) {

        }

    }

    @Test
    public void anotherAmazonTest() {
        //Test Data
        String menuItemToSelect = "New Releases";

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://amazon.de");

        wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        closeAllMessages();
        openMenuItem(menuItemToSelect);
//        wait.until(ExpectedConditions.elementToBeClickable(AMAZON_LEFT_MENU_ITEM));
        openLeftMenuItem("Books");

    }

    //https://youtu.be/uWnfiI9CL1g?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=3746
    private void openMenuItem(String itemName) {
        List<WebElement> menuItems = browser.findElements(AMAZON_MAIN_MENU_ITEM);
//        menuItems - list that we are checking
//        WebElement we - variable where we will store each list variable
        for (WebElement we: menuItems) {
            if (we.getText().equals(itemName)) {
                we.click();
                break;
            }
        }
    }

    private  void openLeftMenuItem(String itemName) {
         List<WebElement> menuItems = browser.findElements(AMAZON_LEFT_MENU_ITEM);
         for (WebElement we: menuItems) {
             if (we.getText().equals(itemName)) {
                 we.click();
                 break;
             }
         }
    }

    private void closeAllMessages() {
        wait.until(ExpectedConditions.elementToBeClickable(AMAZON_ACCEPT_COOKIES_BTN)); //https://habr.com/ru/post/443754/
        browser.findElement(AMAZON_ACCEPT_COOKIES_BTN).click();

        wait.until(ExpectedConditions.elementToBeClickable(AMAZON_CONTINUE_BTN));
        browser.findElement(AMAZON_CONTINUE_BTN).click();
    }
}
