import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    StringCalculator stringCalculator;
    int result;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void whenEmptyString_thenReturnZero() {
        result = stringCalculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void whenOneNumberIsGiven_thenReturnThatNumber() {
        result = stringCalculator.add("6");
        assertEquals(6, result);
    }

    @Test
    public void whenTwoNumbersAreGiven_thenReturnTheSum() {
        result = stringCalculator.add("1,2");
        assertEquals(3,result);
    }

    @Test
    public void whenMultipleNumbersAreGiven_thenReturnSum() {
        result = stringCalculator.add("1,2,3,5");
        assertEquals(11,result);
    }

    @Test
    public void whenThreeNumbersSeparatedByNewLineAreGiven_thenReturnTheSum() {
        result = stringCalculator.add("1,2\n3");
        assertEquals(6,result);
    }

    @Test
    public void whenCustomDelimiterIsGiven_splitByThisDelimiterAndReturnSum() {
        result = stringCalculator.add("//;\n1;2");
        assertEquals(3, result);
    }

    @Test
    public void whenAnotherCustomDelimiterIsGiven_splitByThisDelimiterAndReturnSum() {
        result = stringCalculator.add("//p\n8p17");
        assertEquals(25, result);
    }

    @Test
    public void whenNegativeNumberIsGiven_throwException() {
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage("negatives not allowed [-1, -2]");
        result = stringCalculator.add("-1,-2,3");
    }

    @Test
    public void whenOneNegativeNumberIsGiven_throwException() {
        exceptionRule.expect(NumberFormatException.class);
        exceptionRule.expectMessage("negatives not allowed -7");
        result = stringCalculator.add("-7");
    }
}