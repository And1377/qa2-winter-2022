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


public class TicketsPractice {

    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By DESTANATION_FROM = By.xpath(".//span[@class = 'bTxt'][1]");
//    private final By DESTANATION_FROM = By.xpath(".//span[@class = 'bTxt']['RIX']"); ----------- WRONG!
    private final By DESTANATION_TO = By.xpath(".//span[@class = 'bTxt'][2]");
//    private final By DESTANATION_TO = By.xpath(".//span[@class = 'bTxt']['SFO']"); -------------- WRONG!
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");

private WebDriver browser;
private WebDriverWait wait;


    @Test
    public void reservationCheck2() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://www.qaguru.lv:8089/tickets/");
        wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        //https://youtu.be/BFOJYQ-BWz0?list=PL29imBtAdLy-9H5wHMT0BRF4RziIQuAEr&t=1725

        Select airportFrom = new Select(browser.findElement(FROM));
        airportFrom.selectByValue("RIX");

        Select airportTo = new Select(browser.findElement(TO));
        airportTo.selectByValue("SFO");

        browser.findElement(GO_BTN).click();

    }

    private void type(By locator, String text) {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);
    }
}
