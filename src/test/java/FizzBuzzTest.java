import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;


public class FizzBuzzTest {

    @Test
    void fizzBuzzCalcNormalNumber1() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("1", fizzBuzz.calc(1));
    }

    @Test
    void fizzBuzzCalcNormalNumber2() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("2", fizzBuzz.calc(2));
    }

    @Test
    void fizzBuzzCalcFizzNumber3() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("Fizz", fizzBuzz.calc(3));
    }

    @Test
    void fizzBuzzCalcFizzNumber6() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("Fizz", fizzBuzz.calc(6));
    }

    @Test
    void fizzBuzzCalcBuzzNumber5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("Buzz", fizzBuzz.calc(5));
    }

    @Test
    void fizzBuzzCalcBuzzNumber10() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("Buzz", fizzBuzz.calc(10));
    }

    @Test
    void fizzBuzzCalcFizzBuzzNumber15() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("FizzBuzz", fizzBuzz.calc(15));
    }

    @Test
    void fizzBuzzCalcFizzBuzzNumber30() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("FizzBuzz", fizzBuzz.calc(30));
    }

    @Test
    void fizzBuzzCalc1To100() throws IOException {
        FizzBuzz fizzBuzz = new FizzBuzz();
        File file = new File("./src/test/java/fizz1to100.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        for(int i = 1; i <= 100; i++) {
            String line = br.readLine();
            if(line != null) {
                line = line.strip();
                assertEquals(line, fizzBuzz.calc(i));
            }
            else {
                fail();
            }
        }
    }
}
