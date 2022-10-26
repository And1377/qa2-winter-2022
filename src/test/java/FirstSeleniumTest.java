import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstSeleniumTest {
    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    @Test
    public void openHomePageCheck() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver browser  = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://www.discovercars.com/");

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();
    }
}
