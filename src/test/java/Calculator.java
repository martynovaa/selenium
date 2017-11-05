import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calculator {

    private static WebDriver driver;

    @BeforeClass
    public static void start() {
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/User/Desktop/GL%20Base%20Camp/7.%20Test%20Automation/SeleniumWebdriver/calc.html");
    }

    @Before
    public void clean(){
        driver.findElement(By.xpath("//input[@value='C']")).click();
    }

    @Test
    public void addition() {
        driver.findElement(By.xpath("//input[@value='8']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='6']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("141", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void subtracting() {
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='6']")).click();
        driver.findElement(By.xpath("//input[@value='-']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("35", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void multiplication() {
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='x']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("492", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void division() {
        driver.findElement(By.xpath("//input[@value='9']")).click();
        driver.findElement(By.xpath("//input[@value='9']")).click();
        driver.findElement(By.xpath("//input[@value='/']")).click();
        driver.findElement(By.xpath("//input[@value='3']")).click();
        driver.findElement(By.xpath("//input[@value='3']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("3", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
