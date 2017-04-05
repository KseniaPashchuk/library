package by.epam.library.parser;

import by.epam.library.entity.Book;
import by.epam.library.exception.PublicationFormatException;
import by.epam.library.publicationtype.BookType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class BookParserTest {
    private List<String> testLine;
    private Book expected;

    public BookParserTest(List<String> testLine, Book expected) {
        this.testLine = testLine;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> stepUp() {
        return Arrays.asList(new Object[][]{
                { new ArrayList<String>() {{
                    add("Book");
                    add("Java Методы програграммирования");
                    add("Четыре четверти");
                    add("12.90");
                    add("897");
                    add("Блинов");
                    add("textbook");
                }},  new Book("Java Методы програграммирования", "Четыре четверти", new BigDecimal(12.90),
                        897, "Блинов", BookType.TEXTBOOK)},
                { new ArrayList<String>() {{
                    add("Book");
                    add("Book");
                    add("Book");
                    add("Book");
                    add("Book");
                    add("Book");
                    add("Book"); }},  null}
        });
    }
    @Test
    public void parse() throws Exception {
        try {
            assertThat(BookParser.parse(testLine), is(expected));
        } catch(PublicationFormatException ex){
            assertEquals("Incorrect data format", ex.getMessage());
        }
    }

}