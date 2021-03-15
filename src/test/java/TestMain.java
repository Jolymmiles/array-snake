import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
        int[] expected = new int[]{1, 2, 3, 4, 5, 10, 9, 8, 7, 6, 11, 12, 13, 14, 15, 20, 19, 18, 17, 16};
        int[] actual = Arrays.stream(
                outContent.toString()
                        .replaceAll("[\\r\\n]", "")
                        .split("\\t")
        ).mapToInt(Integer::parseInt).toArray();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainSecond() {
        String data = "2 2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int[] expected = new int[]{1, 2, 4, 3};
        int[] actual = Arrays.stream(
                outContent.toString()
                        .replaceAll("[\\r\\n]", "")
                        .split("\\t")
        ).mapToInt(Integer::parseInt).toArray();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainThird() {
        String data = "10 2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int[] expected = new int[]{1, 2, 4, 3, 5, 6, 8, 7, 9, 10, 12, 11, 13, 14, 16, 15, 17, 18, 20, 19};
        int[] actual = Arrays.stream(
                outContent.toString()
                        .replaceAll("[\\r\\n]", "")
                        .split("\\t")
        ).mapToInt(Integer::parseInt).toArray();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainForth() {
        String data = "2 10";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        int[] actual = Arrays.stream(
                outContent.toString()
                        .replaceAll("[\\r\\n]", "")
                        .split("\\t")
        ).mapToInt(Integer::parseInt).toArray();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainFifth() {
        String data = "3 3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int[] expected = new int[]{1, 2, 3, 6, 5, 4, 7, 8, 9};
        int[] actual = Arrays.stream(
                outContent.toString()
                        .replaceAll("[\\r\\n]", "")
                        .split("\\t")
        ).mapToInt(Integer::parseInt).toArray();

        assertArrayEquals(expected, actual);
    }

}