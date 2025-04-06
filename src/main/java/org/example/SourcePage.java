package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class SourcePage {

    public WebDriver driver;
    public String url = "https://www.rzd.ru/";


    @Before
    public void setUp() {
            System.setProperty("webdriver.chrome.driver", "webdriver\\chromedriver.exe");
            Configuration.browser = "chrome";
            Configuration.timeout = 10000;
            Configuration.pageLoadTimeout = 10000;
            Configuration.browserSize = "1920x1080";
            open(url);
        }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }

    public void time() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
