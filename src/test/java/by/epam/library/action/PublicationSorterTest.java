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

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PublicationSorterTest {
    private Library library;
    private Library librarySortedByName;
    private Library librarySortedByTypeAndName;
    private Library librarySortedByTypeAndPrice;

    @Before
    public void initTest() {
        library = new Library(new ArrayList<Publication>() {{
            add(new Book("Java Методы програграммирования", "Четыре четверти", new BigDecimal("12.90"),
                    897, "Блинов", BookType.TEXTBOOK));
            add(new Magazine("Naked Science", "Naked Science", new BigDecimal("18.60"),
                    15, 10, MagazinePeriod.MONTHLY, MagazineType.SCIENTIFIC));
            add(new Book("Имя розы", "АСТ", new BigDecimal("8.105"),
                    450, "Умберто Эко", BookType.IMAGINATIVE));
            add(new Magazine("Юность", "Правда", new BigDecimal("6.20"),
                    8, 15, MagazinePeriod.MONTHLY, MagazineType.LITERARY));
            add(new Magazine("National Geografic", "BLA", new BigDecimal("7.80"),
                    36, 2, MagazinePeriod.MONTHLY, MagazineType.SCIENTIFIC));
        }});
        librarySortedByName = new Library(new ArrayList<Publication>() {{
            add(new Book("Java Методы програграммирования", "Четыре четверти", new BigDecimal("12.90"),
                    897, "Блинов", BookType.TEXTBOOK));
            add(new Magazine("Naked Science", "Naked Science", new BigDecimal("18.60"),
                    15, 10, MagazinePeriod.MONTHLY, MagazineType.SCIENTIFIC));
            add(new Magazine("National Geografic", "BLA", new BigDecimal("7.80"),
                    36, 2, MagazinePeriod.MONTHLY, MagazineType.SCIENTIFIC));
            add(new Book("Имя розы", "АСТ", new BigDecimal("8.105"),
                    450, "Умберто Эко", BookType.IMAGINATIVE));
            add(new Magazine("Юность", "Правда", new BigDecimal("6.20"),
                    8, 15, MagazinePeriod.MONTHLY, MagazineType.LITERARY));
        }});
        librarySortedByTypeAndName = new Library(new ArrayList<Publication>() {{
            add(new Book("Java Методы програграммирования", "Четыре четверти", new BigDecimal("12.90"),
                    897, "Блинов", BookType.TEXTBOOK));
            add(new Book("Имя розы", "АСТ", new BigDecimal("8.105"),
                    450, "Умберто Эко", BookType.IMAGINATIVE));
            add(new Magazine("Naked Science", "Naked Science", new BigDecimal("18.60"),
                    15, 10, MagazinePeriod.MONTHLY, MagazineType.SCIENTIFIC));
            add(new Magazine("National Geografic", "BLA", new BigDecimal("7.80"),
                    36, 2, MagazinePeriod.MONTHLY, MagazineType.SCIENTIFIC));
            add(new Magazine("Юность", "Правда", new BigDecimal("6.20"),
                    8, 15, MagazinePeriod.MONTHLY, MagazineType.LITERARY));
        }});
        librarySortedByTypeAndPrice = new Library(new ArrayList<Publication>() {{
            add(new Book("Имя розы", "АСТ", new BigDecimal("8.105"),
                    450, "Умберто Эко", BookType.IMAGINATIVE));
            add(new Book("Java Методы програграммирования", "Четыре четверти", new BigDecimal("12.90"),
                    897, "Блинов", BookType.TEXTBOOK));
            add(new Magazine("Юность", "Правда", new BigDecimal("6.20"),
                    8, 15, MagazinePeriod.MONTHLY, MagazineType.LITERARY));
            add(new Magazine("National Geografic", "BLA", new BigDecimal("7.80"),
                    36, 2, MagazinePeriod.MONTHLY, MagazineType.SCIENTIFIC));
            add(new Magazine("Naked Science", "Naked Science", new BigDecimal("18.60"),
                    15, 10, MagazinePeriod.MONTHLY, MagazineType.SCIENTIFIC));
        }});
    }

    @After
    public void destroyTest() {
        library = null;
        librarySortedByName = null;
        librarySortedByTypeAndName = null;
        librarySortedByTypeAndPrice = null;
    }

    @Test
    public void nameSort() throws Exception {
        PublicationSorter.sortByName(library);
        assertEquals(library.getLibrary(), librarySortedByName.getLibrary());
    }

    @Test
    public void typeAndNameSort() throws Exception {
        PublicationSorter.sortByTypeAndName(library);
        assertEquals(library.getLibrary(), librarySortedByTypeAndName.getLibrary());
    }

    @Test
    public void typeAndPriceSort() throws Exception {
        PublicationSorter.sortByTypeAndPrice(library);
        assertEquals(library.getLibrary(), librarySortedByTypeAndPrice.getLibrary());
    }

}