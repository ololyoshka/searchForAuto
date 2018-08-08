package pages.actions;
import com.codeborne.selenide.Condition;
import pages.locators.SearchPageLocators;

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
}
