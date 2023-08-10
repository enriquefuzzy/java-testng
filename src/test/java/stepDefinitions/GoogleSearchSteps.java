package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchSteps {
    WebDriver driver;

    // Initialize and tear down WebDriver with Hooks
    public GoogleSearchSteps() {
        driver = Hooks.driver;
    }

    @Given("I am on the Google search page")
    public void i_am_on_the_google_search_page() {
        driver.get("https://www.google.com/");
    }

    @When("I search Google for {string}")
    public void i_search_google_for(String pet) {
        WebElement el = driver.findElement(By.cssSelector("[name=q]"));
        el.sendKeys(pet, Keys.RETURN);
    }

    @Then("I should see search results for {string}")
    public void i_should_see_search_results_for(String search) {
        WebElement title = driver.findElement(By.cssSelector("[data-attrid=title]"));
        String url = driver.getCurrentUrl();
        if (search.equals("Dogs") || search.equals("dogs")) {
            Assert.assertEquals("Dog", title.getText());
            Assert.assertTrue(url.contains("/search?q=Dogs"));
        } else if (search.equals("Cats") || search.equals("cats")) {
            Assert.assertEquals("Cat", title.getText());
            Assert.assertTrue(url.contains("/search?q=Cats"));
        }
    }
}
