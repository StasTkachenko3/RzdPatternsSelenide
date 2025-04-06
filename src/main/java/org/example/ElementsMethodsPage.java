package org.example;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ElementsMethodsPage extends SourcePage {


    private final SelenideElement from = $x("//input[@placeholder='Откуда']");
    private final SelenideElement fromChoose = $x("//li[@aria-label='Саратов' and @role='group']");
    private final SelenideElement where = $x("//input[@id='direction-to']");
    private final ElementsCollection whereChoose = $$x("//li[@aria-label='Москва' and @role='group']");
    private final SelenideElement thereDate = $x("//input[@id='datepicker-from']");
    private final SelenideElement outDate = $x("//input[@id='datepicker-to']");
    private final SelenideElement chooseDate = $x("//td[@data-day='16' and @data-month='5']");
    private final SelenideElement chooseDateOut = $x("//td[@data-day='20' and @data-month='5']");
    private final SelenideElement findBillets = $x("//a[@aria-label='Найти маршруты']");
    private final SelenideElement assertCityFrom = $x("//div[@class='card-route__station card-route__station--from']");
    private final ElementsCollection assertCityTo = $$x("//div[@class='card-route__station card-route__station--to']");
    private final SelenideElement calendarTo = $x("/html/body/div[1]/header/div[2]/section/div[3]/div/div[1]/div[1]/div[2]/div[6]/div[4]");
    private final SelenideElement calendatNext = $x("/html/body/div[1]/header/div[2]/section/div[3]/div/div[1]/div[1]/div[2]/div[6]/div[3]/a[1]");

    public void findBillets(String fromCity, String whereCity, String there, String out) {

        from.sendKeys(fromCity);
        fromChoose.shouldBe(visible).click();
        where.sendKeys(whereCity);
        whereChoose.get(0).click();
        thereDate.sendKeys(there);
        chooseDate.click();
        outDate.sendKeys(out);
        chooseDateOut.click();
        findBillets.shouldBe(clickable).click();

    }
    //проверяем что точно едем из  Саратова
    public void  asertionsFrom() throws InterruptedException {
        String chossenCityTo = assertCityFrom.getText();
        assertCityFrom.shouldBe(visible);
        Assert.assertEquals("Саратов 1 Пасс",chossenCityTo);

    }
    //проверяем что точно едем в  Москву
    public void  asertionsTo() throws InterruptedException {
        String actualText = assertCityTo.get(0).text();
        Assert.assertEquals("Москва Павелецкая",actualText);

    }

}
