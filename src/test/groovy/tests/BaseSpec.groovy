package tests

import io.github.bonigarcia.wdm.ChromeDriverManager
import objects.CalculatorPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import spock.lang.Shared
import spock.lang.Specification

class BaseSpec extends Specification {

    @Shared
    WebDriver driver
    @Shared
    CalculatorPage calc

    def setupSpec() {
        ChromeDriverManager.getInstance().setup()
        //ChromeOptions opt = new ChromeOptions().setHeadless(true);
        driver = new ChromeDriver();
        calc = new CalculatorPage(driver)
    }

    def cleanupSpec() {
        driver.quit();
    }
}