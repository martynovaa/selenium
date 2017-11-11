package tests;

import objects.CalculatorPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DataDriven extends Base {

    private static CalculatorPage calc;

    @Parameterized.Parameter
    public String expression;

    @Parameterized.Parameter(1)
    public String expected;

    @BeforeClass
    public static void setup() {
        calc = new CalculatorPage(driver);
        calc.open();
    }

    @Before
    public void cleanup() {
        calc.clear();
    }

    @Test
    public void calculator_DataDrivenTest(){
        Assert.assertEquals(expected, calc.calculate(expression));
    }

    @Parameterized.Parameters (name="Test: {0}={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "85+56", "141" },
                { "56-21", "35" },
                { "41x12", "492" },
                { "99/33", "3" },
                { "1.02+1.001", "2.021" },

        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}

