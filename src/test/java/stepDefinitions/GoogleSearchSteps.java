package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchSteps {
    WebDriver driver;

    @Given("I am on the Google search page")
    public void i_am_on_the_google_search_page() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @When("I search Google for {string}")
    public void i_search_google_for(String string) {
        WebElement el = driver.findElement(By.cssSelector("[name=q]"));
        el.sendKeys("Dogs", Keys.RETURN);
    }

    @Then("I should see search results for {string}")
    public void i_should_see_search_results_for(String string) {
        WebElement title = driver.findElement(By.cssSelector("[data-attrid=title]"));
        Assert.assertEquals("Dog", title.getText());
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("/search?q=Dogs"));
        driver.quit();
    }
}
