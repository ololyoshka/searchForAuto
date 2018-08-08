package pages.assertions;

import pages.locators.SearchPageLocators;

import static org.junit.Assert.assertTrue;

public class SearchPageAssertions extends SearchPageLocators {
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
            firstItemPrice = itemPrice.get(i).getText().replaceAll("[^.0-9]+","");
            secondItemPrice = itemPrice.get(i+1).getText().replaceAll("[^.0-9]+","");
            assertTrue(
                    String.format(
                            "Prices are supposed to be sorted by descending but %s bigger than %s",
                            secondItemPrice,
                            firstItemPrice
                    ),
                    // >= operator is used in following as prices for 2 or even more items in a row could be the same
                    // proof: java.lang.AssertionError: Prices are supposed to be sorted by descending but 35.990 bigger than 35.990
                    Float.parseFloat(firstItemPrice) >= Float.parseFloat(secondItemPrice));
        }
    }

}
