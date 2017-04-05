package by.epam.library.parser;

import by.epam.library.entity.Book;
import by.epam.library.exception.PublicationFormatException;
import by.epam.library.publicationtype.BookType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BookParserTest {
    private List<String> testList1;
    private List<String> testList2;
    private Book expected;

    @Before
    public void stepUp() {

        testList1 = new ArrayList<String>() {{
            add("Book");
            add("Java Методы програграммирования");
            add("Четыре четверти");
            add("12.90");
            add("897");
            add("Блинов");
            add("textbook");
        }};
        testList2 = new ArrayList<String>() {{
            add("Book");
            add("Book");
            add("Book");
            add("Book");
            add("Book");
            add("Book");
            add("Book");
        }};
        expected = new Book("Java Методы програграммирования", "Четыре четверти", new BigDecimal(12.90),
                897, "Блинов", BookType.TEXTBOOK);
    }

    @After
    public void destroyTest() {
        testList1 = null;
        testList2 = null;
        expected = null;
    }

    @Test
    public void parse1() throws Exception {
        assertThat(BookParser.parse(testList1), is(expected));
    }

    @Test
    public void parse2() throws Exception {
        try {
            BookParser.parse(testList2);
            fail("Test  should have thrown a PublicationFormatException");
        } catch (PublicationFormatException ex) {
            assertEquals("Incorrect data format", ex.getMessage());
        }
    }
}