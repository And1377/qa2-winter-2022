package pageobject;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFunc {
    private WebDriver browser;
    private WebDriverWait wait;

    public WebDriver getBrowser() {
        return browser;
    }

    public BaseFunc() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver(options);
        browser.manage().window().maximize();
        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    public void openUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        browser.get(url);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void select(By locator, String value) {
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(we);
        select.selectByValue(value);
    }

    public void selectByText(By locator, String text) {
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(we);
        select.selectByVisibleText(text);
    }

    public void type(By locator, String text) {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);
    }

    public void type(By locator, int text) {
        type(locator, String.valueOf(text));
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findElements(By locator) {
        return browser.findElements(locator);
    }

    public void waitForElementsCountToBe(By locator, int count) {
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, count));
    }

    public void compare(int expected, int actual, boolean expectedResult) {
        if (expectedResult){
            Assertions.assertEquals(expected, actual);
        }
        else {
            Assertions.assertNotEquals(expected, actual);
        }
    }

    public int getValueFromText(By locator, String befor, String after) {
        String text = findElement(locator).getText();
        return Integer.parseInt(StringUtils.substringBetween(text, befor, after));
    }

    public void compare(String text, By locator) {
        Assertions.assertEquals(text, browser.findElement(locator).getText());
    }

    public void findAndClick(String itemName, By locator) {
        List<WebElement> menuItems = browser.findElements(locator);
        for (WebElement we : menuItems) {
            if (we.getText().equals(itemName)) {
                we.click();
                break;
            }
        }
    }
}
