import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTest {
    @Test
    public void Test1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(3000);
        System.out.println("Heyo folks!");
        driver.quit();
    }
}
