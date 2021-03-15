import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public TestMain() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainFirst() {
        String data = "4 5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "1\t2\t3\t4\t5\t\r\n10\t9\t8\t7\t6\t\r\n11\t12\t13\t14\t15\t\r\n20\t19\t18\t17\t16\t";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testMainSecond() {
        String data = "2 2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "1\t2\t\r\n4\t3\t";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testMainThird() {
        String data = "10 2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "1\t2\t\r\n4\t3\t\r\n5\t6\t\r\n8\t7\t\r\n9\t10\t\r\n12\t11\t\r\n13\t14\t\r\n16\t15\t\r\n17\t18\t\r\n20\t19\t";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testMainForth() {
        String data = "2 10";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t\r\n20\t19\t18\t17\t16\t15\t14\t13\t12\t11\t";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testMainFifth() {
        String data = "3 3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "1\t2\t3\t\r\n6\t5\t4\t\r\n7\t8\t9\t";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

}