package pages.actions;
import com.codeborne.selenide.Condition;
import pages.locators.SearchPageLocators;
import static org.junit.Assert.*;

import static com.codeborne.selenide.Selenide.*;
import static utils.CommonConstants.searchPageURL;

public class SearchPageActions extends SearchPageLocators {

    public void openSearchPage () {
        open(searchPageURL);
        /*
            a hacky way to wait until something is loaded as
            there is no specific indicator of being on search page
            despite different small components like filter etc.
         */
        bodyClass.shouldBe(Condition.appear);
    }

    public void filterByRegistrationYear(String year) {
        filterByYear.click();
        yearRangeSelect
                .should(Condition.appear)
                .selectOption(year);
    }

    public void activeFilterIsApplied (String filterValue) {
        activeFilter
                .should(Condition.visible)
                .shouldHave(Condition.text(filterValue));
    }

    public void processSorting (String sortType) {
        sortBy.selectOption(sortType);
    }

    public void verifyFilterByRegistration (String year) {
        searchResultItems
                .forEach(elem -> {
                    String actualYear = elem.findAll(itemSpec).first().getText();
                    actualYear = actualYear.replaceAll("\\D+","");
                    assertTrue(
                            String.format(
                                    "Registration year should be equal or higher than %s but it is %s",
                                    year,
                                    actualYear),
                            Integer.parseInt(actualYear) >= Integer.parseInt(year));
                });
    }

    public void verifySortByPriceDescending () {
        String firstItemPrice;
        String secondItemPrice;
        for (int i = 0; i < itemPrice.size() - 1; i++) {
            firstItemPrice = itemPrice.get(i).getText().replaceAll("\\D+","");
            secondItemPrice = itemPrice.get(i+1).getText().replaceAll("\\D+","");
            assertTrue(
                    String.format(
                            "Prices are supposed to be sorted by descending but %s bigger than %s",
                            secondItemPrice,
                            firstItemPrice
                    ),
                    // >= operator is used in following as prices for 2 or even more items in a row could be the same
                    // proof: java.lang.AssertionError: Prices are supposed to be sorted by descending but 35990 bigger than 35990
                    Integer.parseInt(firstItemPrice) >= Integer.parseInt(secondItemPrice));
        }
    }
}
