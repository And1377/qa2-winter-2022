package pageobject.pages;

import org.openqa.selenium.By;
import pageobject.BaseFunc;

public class HomePage {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

    }
    public void selectAirports(String from, String to) {
   //select from drop-down "from" airport
        baseFunc.select(FROM, from);
   //select from drop-down "to" airport
        baseFunc.select(TO, to);
   //click submit BTN
        baseFunc.click(GO_BTN);

    }
}
