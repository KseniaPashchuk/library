package by.epam.library.parser;

import by.epam.library.entity.Book;
import by.epam.library.entity.Magazine;
import by.epam.library.exception.PublicationFormatException;
import by.epam.library.publicationtype.BookType;
import by.epam.library.publicationtype.MagazinePeriod;
import by.epam.library.publicationtype.MagazineType;
import org.junit.After;
import org.junit.Before;
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
    private List<String> testList1;
    private List<String> testList2;
    private Magazine expected;

    @Before
    public void stepUp() {
        testList1 = new ArrayList<String>() {{
            add("Magazine");
            add("Юность");
            add("Правда");
            add("6.20");
            add("8");
            add("15");
            add("monthly");
            add("Literary");
        }};
        testList2 = new ArrayList<String>() {{
            add("Magazine");
            add("Magazine");
            add("Magazine");
            add("Magazine");
            add("Magazine");
            add("Magazine");
            add("Magazine");
            add("Magazine");
        }};
        expected = new Magazine("Юность", "Правда", new BigDecimal(6.20),
                8, 15, MagazinePeriod.MONTHLY, MagazineType.LITERARY);
    }


    @After
    public void destroyTest() {
        testList1 = null;
        testList2 = null;
        expected = null;
    }

    @Test
    public void parse1() throws Exception {
        assertThat(MagazineParser.parse(testList1), is(expected));
    }

    @Test
    public void parse2() throws Exception {
        try {
            MagazineParser.parse(testList2);
            fail("Test  should have thrown a PublicationFormatException");
        } catch (PublicationFormatException ex) {
            assertEquals("Incorrect data format", ex.getMessage());
        }
    }
}