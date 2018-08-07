package tests;

import org.testng.annotations.Test;
import pages.actions.SearchPageActions;
import utils.BaseClass;

import static utils.CommonConstants.*;

public class SearchTest extends BaseClass {

    public SearchPageActions searchPage;

    @Test(priority = 1)
    public void checkSearchFilteringAndSorting() {
        searchPage = new SearchPageActions();
        searchPage.openSearchPage();
        searchPage.filterByRegistrationYear(year);
        searchPage.activeFilterIsApplied(year);
        searchPage.processSorting(sortType);
        searchPage.verifyFilterByRegistration(year);
        searchPage.verifySortByPriceDescending();
    }

}
