import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Calculator2Test {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void whenAdd10To5ThenResult15() {
        double expected = 15;
        double result = calculator.add(10, 5);
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void when5AddTo10AsStringThenResult15() {
        double expected = 15;
        double result = calculator.add("10", "5");
        assertEquals(expected, result, 0.001);
    }

    @Test ( expected = Exception.class )
    public void whenInputIncorrectValueThenThrowException() {
        calculator.add("asdfgasdf", "5");
    }

    @Test
    public void whenAdd100To50ThenResult150() {
        double expected2 = 150;
        double result2 = calculator.add(100, 50);
        assertEquals(expected2, result2, 0.001);
    }

    @Test
    public void whenDivide100By10ThenResult10() {
        double expected = 10;
        double result = calculator.divide(100, 10);
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void whenDivide6By3AsStringThenResult2() {
        double expected = 2;
        double result = calculator.divide("6", "3");
        assertEquals(expected, result, 0.001);
    }

    @Test ( expected = NumberFormatException.class )
    public void whenDivideIncorrectValueThenThrowException() {
        calculator.divide("asdfgasdf", "5");
    }

    @Test
    public void whenDivide9By3ThenResult3() {
        double expected2 = 3;
        double result2 = calculator.divide(9, 3);
        assertEquals(expected2, result2, 0.001);
    }

    @Test
    public void when5MultipleBy10ThenResult50() {
        double expected = 50;
        double result = calculator.multiply(5, 10);
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void when3MultipleBy3ThenResult9() {
        double expected2 = 9;
        double result2 = calculator.multiply(3, 3);
        assertEquals(expected2, result2, 0.001);
    }



    @After
    public void close() {
        calculator = null;
    }
}