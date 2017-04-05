package by.epam.library.parser;

import by.epam.library.entity.Book;
import by.epam.library.entity.Magazine;
import by.epam.library.exception.PublicationFormatException;
import by.epam.library.publicationtype.BookType;
import by.epam.library.publicationtype.MagazinePeriod;
import by.epam.library.publicationtype.MagazineType;
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
public class MagazineParserTest {
    private List<String> testLine;
    private Magazine expected;

    public MagazineParserTest(List<String> testLine, Magazine expected) {
        this.testLine = testLine;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> stepUp() {
        return Arrays.asList(new Object[][]{
                {new ArrayList<String>() {{
                    add("Magazine");
                    add("Юность");
                    add("Правда");
                    add("6.20");
                    add("8");
                    add("15");
                    add("monthly");
                    add("Literary");
                }}, new Magazine("Юность", "Правда", new BigDecimal(6.20),
                        8, 15, MagazinePeriod.MONTHLY, MagazineType.LITERARY)},
                {new ArrayList<String>() {{
                    add("Magazine");
                    add("Magazine");
                    add("Magazine");
                    add("Magazine");
                    add("Magazine");
                    add("Magazine");
                    add("Magazine");
                    add("Magazine");
                }}, null}
        });
    }

    @Test
    public void parse() throws Exception {
        try {
            assertThat(BookParser.parse(testLine), is(expected));
        } catch (PublicationFormatException ex) {
            assertEquals("Incorrect data format", ex.getMessage());
        }
    }
}