import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

public class FizzBuzzTestIO {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void checkFromInputTest(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        InputStream originalIn = System.in;
        System.setIn(in);
        fizzBuzz.checkFromInput();
        System.setIn(originalIn);
        assertEquals("Please enter a number:\r\nThe result is: 1\r\n",outContent.toString());
    }

    @Test
    void checkFromInputExceptionTest(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        ByteArrayInputStream in = new ByteArrayInputStream("1a".getBytes());
        InputStream originalIn = System.in;
        System.setIn(in);
        assertThrows(NumberFormatException.class, fizzBuzz::checkFromInput);
        System.setIn(originalIn);
    }


    @Test
    void printRangeTest() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.printRange(1, 10);
        String lines = "1\r\n" +
                "2\r\n" +
                "Fizz\r\n" +
                "4\r\n" +
                "Buzz\r\n" +
                "Fizz\r\n" +
                "7\r\n" +
                "8\r\n" +
                "Fizz\r\n" +
                "Buzz\r\n";
        assertEquals(lines, outContent.toString());
    }

    @Test
    void FizzBuzzTestPrintRange1to100() throws IOException {
        FizzBuzz fizzBuzz = new FizzBuzz();
        File file = new File("./src/test/java/fizz1to100.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder lines = new StringBuilder();
        String line;
        while((line = br.readLine()) != null) {
            lines.append(line).append("\r\n");
        }
        fizzBuzz.printRange(1, 100);
        assertEquals(outContent.toString(), lines.toString());
    }
}
