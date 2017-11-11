package tests;

import objects.CalculatorPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NewCalculator extends Base {

    static CalculatorPage calc = new CalculatorPage(driver);

    @BeforeClass
    public static void openPage() {
        calc.open();
    }

    @Before
    public void cleanup() {
        calc.clear();
    }

    @Test
    public void add_test() {
        Assert.assertEquals("141", calc.calculate("85+56"));
    }

    @Test
    public void sub_test() {
        Assert.assertEquals("35", calc.calculate("56-21"));
    }

    @Test
    public void mult_test() {
        Assert.assertEquals("492", calc.calculate("41x12"));
    }

    @Test
    public void div_test() {
        Assert.assertEquals("3", calc.calculate("99/33"));
    }

}
