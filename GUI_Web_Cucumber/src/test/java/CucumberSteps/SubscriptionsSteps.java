package CucumberSteps;

import com.shaft.driver.SHAFT;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Subscription;

public class SubscriptionsSteps {
    private SHAFT.GUI.WebDriver driver;

    /**
     * Requires the following setting in the cucumber.properties file to run
     * cucumber.glue=CucumberSteps
     */
    
    @Given("I Open the target browser")
    public void i_open_the_target_browser() {
        this.driver = new SHAFT.GUI.WebDriver();

    }

    @When("I navigate to subscribtion page.")
    public void i_navigate_to_google_homepage() {
    	new Subscription(driver).navigate();
    	new Subscription(driver).verifyBrowserTitleIsCorrect();
    }

    @Then("Verify that the country selected is {word}.")
    public void verify_the_country_selected_name(String countryName) {
    	new Subscription(driver).verifyNameOfSelectedCountry(countryName);
    }

    @When("Click on the country button.")
    public void click_on_the_country_button() {
    	new Subscription(driver).clickCountryButton();
    }
    
    @When("Choose {word} Country.")
    public void choose_country(String countryName) {
    	new Subscription(driver).chooseCountry(countryName);
    }
   
    @Then("Check that the planes prices of {word} country are correct.")
    public void check_the_planes_prices_of_country(String countryName) {
    	new Subscription(driver).checkPrice(countryName);
    }
    
    @Then("Check that the prices currency of {word} country are correct.")
    public void check_the_prices_currency_for_country(String countryName) {
    	new Subscription(driver).checkPricesCurrency(countryName);
    }
    
    @Then("Verify that plans names are correct.")
    public void verify_that_plans_names_are_correct() {
    	new Subscription(driver).verifyPlansNames();
    }
    
}
