package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;

import java.util.ArrayList;

import java.util.HashMap;

import org.openqa.selenium.By;

public class Subscription {
	private SHAFT.GUI.WebDriver driver;
	SHAFT.TestData.JSON testData = new SHAFT.TestData.JSON("subscription.json");
	private By countryBtn = By.cssSelector("#country-btn:first-child");
	private By countryName = By.id("country-name");
	private By ksaChoice = By.id("sa");
	private By BahrainChoice = By.id("bh");
	private By KuwaitChoice = By.id("kw");
	private By litePrice = By.cssSelector("#currency-lite > b");
	private By litePriceCurrency = By.cssSelector("#currency-lite > i");
	private By classicPrice = By.cssSelector("#currency-classic > b");
	private By classicPriceCurrency = By.cssSelector("#currency-classic > i");
	private By premiumPrice = By.cssSelector("#currency-premium > b");
	private By premiumPriceCurrency = By.cssSelector("#currency-premium > i");
	private By litePlanName = By.id("name-lite");
	private By classicPlanName = By.id("name-classic");
	private By premiumPlanName = By.id("name-premium");

	public Subscription(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	@Step("When I navigate to subscribtion page.")
	public Subscription navigate() {
		driver.browser().navigateToURL(testData.getTestData("url"));
		return this;
	}

	@Step("Then the browser title should be correct.")
	public Subscription verifyBrowserTitleIsCorrect() {
		driver.assertThat().browser().title().isEqualTo(testData.getTestData("title")).perform();
		return this;
	}

	@Step("Verify that the country selected is correct.")
	public Subscription verifyNameOfSelectedCountry(String CountryName) {
		driver.element().assertThat(countryName).text().isEqualTo(CountryName).perform();
		return this;
	}

	@Step("Click on the country button.")
	public Subscription clickCountryButton() {
		driver.element().click(countryBtn);
		return this;
	}

	/**
	 * Check that the prices for the specified country are correct.
	 *
	 * @param countryName The name of the country for which to check the prices.
	 * @return The Subscription object for method chaining.
	 */
	@Step("Check that the prices for the selected country is correct")
	public Subscription checkPrice(String countryName) {
	    // Retrieve the expected prices for different countries
	    HashMap<String, String> expectedPrices = getExpectedPrices();

	    // Retrieve the expected price list for the specified country
	    ArrayList<String> expectedPriceList = getExpectedPriceList(countryName, expectedPrices);

	    // Retrieve the elements for the prices
	    ArrayList<By> priceElements = getPriceElements();

	    // Verify that the prices match the expected values
	    verifyPrices(priceElements, expectedPriceList);

	    return this;
	}

	/**
	 * Get the expected prices for different countries.
	 *
	 * @return A HashMap containing the expected prices for different countries.
	 */
	private HashMap<String, String> getExpectedPrices() {
	    HashMap<String, String> expectedPrices = new HashMap<>();
	    expectedPrices.put("KSA", testData.getTestData("ksaPrices"));
	    expectedPrices.put("Bahrain", testData.getTestData("bahrainPrices"));
	    expectedPrices.put("Kuwait", testData.getTestData("kuwaitPrices"));
	    return expectedPrices;
	}

	/**
	 * Get the expected price list for the specified country.
	 *
	 * @param countryName     The name of the country.
	 * @param expectedPrices  The HashMap containing the expected prices for different countries.
	 * @return An ArrayList containing the expected prices for the specified country.
	 */
	private ArrayList<String> getExpectedPriceList(String countryName, HashMap<String, String> expectedPrices) {
	    String[] expectedPricesArray = expectedPrices.get(countryName).split(",");
	    ArrayList<String> expectedPriceList = new ArrayList<>();
	    for (String price : expectedPricesArray) {
	        expectedPriceList.add(price);
	    }
	    return expectedPriceList;
	}

	/**
	 * Get the elements for the prices.
	 *
	 * @return An ArrayList containing the elements for the prices.
	 */
	private ArrayList<By> getPriceElements() {
	    ArrayList<By> priceElements = new ArrayList<>();
	    priceElements.add(litePrice);
	    priceElements.add(classicPrice);
	    priceElements.add(premiumPrice);
	    return priceElements;
	}

	/**
	 * Verify that the prices match the expected values.
	 *
	 * @param priceElements      The elements for the prices.
	 * @param expectedPriceList  The expected prices for the specified country.
	 */
	private void verifyPrices(ArrayList<By> priceElements, ArrayList<String> expectedPriceList) {
	    for (int i = 0; i < priceElements.size(); i++) {
	        By priceElement = priceElements.get(i);
	        String expectedPrice = expectedPriceList.get(i);

	        // Assert that the price element's text is equal to the expected price
	        driver.element().assertThat(priceElement).text().isEqualTo(expectedPrice).perform();
	    }
	}

	/**
	 * Check that the prices currency for the specified country is correct.
	 *
	 * @param countryName The name of the country for which to check the prices currency.
	 * @return The Subscription object for method chaining.
	 */
	public Subscription checkPricesCurrency(String countryName) {
	    // Get the expected currency for the specified country
	    String expectedCurrency = getExpectedCurrency(countryName);

	    // Get the elements for the currency
	    ArrayList<By> currencyElements = getCurrencyElements();

	    // Verify that the prices currency matches the expected value
	    for (By currencyElement : currencyElements) {
	        // Assert that the currency element's text is equal to the expected currency
	        driver.element().assertThat(currencyElement).text().isEqualTo(expectedCurrency).perform();
	    }

	    return this;
	}

	/**
	 * Get the expected currency for the specified country.
	 *
	 * @param countryName The name of the country.
	 * @return The expected currency for the specified country.
	 */
	private String getExpectedCurrency(String countryName) {
	    String expectedCurrency = null;
	    switch (countryName) {
	        case "KSA":
	            expectedCurrency = testData.getTestData("ksaCurrency");
	            break;
	        case "Bahrain":
	            expectedCurrency = testData.getTestData("bahrainCurrency");
	            break;
	        case "Kuwait":
	            expectedCurrency = testData.getTestData("kuwaitCurrency");
	            break;
	    }
	    return expectedCurrency;
	}

	/**
	 * Get the elements for the currency.
	 *
	 * @return An ArrayList containing the elements for the currency.
	 */
	private ArrayList<By> getCurrencyElements() {
	    ArrayList<By> currencyElements = new ArrayList<>();
	    currencyElements.add(litePriceCurrency);
	    currencyElements.add(classicPriceCurrency);
	    currencyElements.add(premiumPriceCurrency);
	    return currencyElements;
	}	@Step("Choose {countryName} Country.")
	public Subscription chooseCountry(String CountryName) {
		By countryToBeSelected = null;
		switch (CountryName) {
		case "KSA":
			countryToBeSelected = ksaChoice;
			break;

		case "Bahrain":
			countryToBeSelected = BahrainChoice;
			break;

		case "Kuwait":
			countryToBeSelected = KuwaitChoice;
			break;
		}
		driver.element().click(countryToBeSelected);
		return this;
	}

	@Step("Verify that plans names are correct.")
	public Subscription verifyPlansNames() {
		driver.element().assertThat(litePlanName).text().isEqualTo("LITE").perform();
		driver.element().assertThat(classicPlanName).text().isEqualTo("CLASSIC").perform();
		driver.element().assertThat(premiumPlanName).text().isEqualTo("PREMIUM").perform();
		return this;
	}

}
