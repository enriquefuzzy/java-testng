package stepDefinitions;

import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    public static WebDriver driver;

    @Before("@web")
    public void init() {
        // Other web drivers could be setup here based on the browser variable passed into the mvn command
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After("@web")
    public void tear_down() {
        driver.quit();
    }

//    @After("@api")
//    public void rest_assured_reset() {
//        RestAssured.reset();
//        System.out.println("Reset rest assured");
//    }

}