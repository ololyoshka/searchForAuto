package pages.locators;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class SearchPageLocators {

    // not really brilliant way to check if the body of search page is attached to the page
    public static SelenideElement bodyClass = $(By.className("container"));

    public static SelenideElement filterByYear = $(By.xpath("//div[@data-qa-selector='filter-year']"));

    public static SelenideElement yearRangeSelect = $(By.xpath("//select[@name='yearRange.min']"));

    public static SelenideElement searchResultsList = $(By.xpath("//div[@data-qa-selector='results-found']/*[@data-qa-selector-type='LIST']"));

    public static ElementsCollection itemPrice = $$(By.xpath("//div[@data-qa-selector='price']")).exclude(Condition.hidden);

    public static SelenideElement activeFilter = $(By.xpath("//*[@data-qa-selector='active-filter']"));

    public static SelenideElement sortBy = $(By.xpath("//*[@name='sort']"));

    public static ElementsCollection searchResultItems = $$(By.xpath("//*[@data-qa-selector='ad']")).exclude(Condition.hidden);

    public static By itemSpec = By.xpath("//*[@data-qa-selector='spec']");

}
