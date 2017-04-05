package by.epam.library.action;

import by.epam.library.collection.Library;
import by.epam.library.entity.Book;
import by.epam.library.entity.Magazine;
import by.epam.library.entity.Publication;
import by.epam.library.publicationtype.BookType;
import by.epam.library.publicationtype.MagazinePeriod;
import by.epam.library.publicationtype.MagazineType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PublicationFinderTest {
    private Library library;

    @Before
    public void initTest() {
        library = new Library(new ArrayList<Publication>() {{
            add(new Book("Java Методы програграммирования", "Четыре четверти", new BigDecimal(12.90),
                    897, "Блинов", BookType.TEXTBOOK));
            add(new Book("Муфта Полботинка и Моховая Борода", "АСТ", new BigDecimal(13.22),
                    200, "Эно Рауд", BookType.IMAGINATIVE));
            add(new Magazine("Naked Science", "Naked Science", new BigDecimal(18.60),
                    15, 10, MagazinePeriod.MONTHLY, MagazineType.SCIENTIFIC));
            add(new Magazine("Cosmopolitan", "BLABLA", new BigDecimal(3.90),
                    100, 3, MagazinePeriod.MONTHLY, MagazineType.GLOSSY));
            add(new Book("Имя розы", "АСТ", new BigDecimal(8.105),
                    450, "Умберто Эко", BookType.IMAGINATIVE));
            add(new Magazine("Юность", "Правда", new BigDecimal(6.20),
                    8, 15, MagazinePeriod.MONTHLY, MagazineType.LITERARY));
            add(new Magazine("National Geografic", "BLA", new BigDecimal(7.80),
                    36, 2, MagazinePeriod.MONTHLY, MagazineType.SCIENTIFIC));
        }});
    }

    @After
    public void destroyTest() {
        library = null;
    }

    @Test
    public void findByPrice1() throws Exception {
        List<Publication> list = PublicationFinder.findByPrice(new BigDecimal(5),new BigDecimal(10), library);
        assertThat(list.size(), is(3));
    }
    @Test
    public void findByPrice2() throws Exception {
        List<Publication> list = PublicationFinder.findByPrice(new BigDecimal(2),new BigDecimal(4), library);
        assertThat(list.size(), is(1));
    }

}