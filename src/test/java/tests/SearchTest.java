package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.actions.SearchPageActions;
import pages.assertions.SearchPageAssertions;
import utils.BaseClass;

import static utils.CommonConstants.*;

public class SearchTest extends BaseClass {

    private SearchPageActions searchPage;
    private SearchPageAssertions searchPageAssertions;

    @BeforeSuite
    public void suiteSetUp() {
        searchPage = new SearchPageActions();
        searchPageAssertions = new SearchPageAssertions();
    }

    @Test(priority = 1)
    public void checkSearchFilteringAndSorting() {
        searchPage.openSearchPage();
        searchPage.filterByRegistrationYear(year);
        searchPage.activeFilterIsApplied(year);
        searchPage.processSorting(sortType);
        urlShouldContain(sortByDescPath);
        searchPageAssertions.verifyFilterByRegistration(year);
        searchPageAssertions.verifySortByPriceDescending();
    }
}
