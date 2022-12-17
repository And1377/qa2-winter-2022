package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseFunc {
    private WebDriver browser;
    private WebDriverWait wait;
    public BaseFunc () {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();

        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }
    public void openUrl(String url) {

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
      browser.get(url);
    }
        public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
        public void select(By locator, String value) {
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(we);
        select.selectByValue(value);
    }

        public void type(By locator, String text) {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);
    }
        public  void waitForElementsCountToBe(By locator, int count) {
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, count));
        }
}
