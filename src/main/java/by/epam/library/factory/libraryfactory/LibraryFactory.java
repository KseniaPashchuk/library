package by.epam.library.factory.libraryfactory;

import by.epam.library.collection.Library;
import by.epam.library.exception.PublicationFormatException;
import by.epam.library.exception.PublicationLogicException;
import by.epam.library.factory.publicationfactory.MagazineFactory;
import by.epam.library.factory.publicationfactory.BookFactory;
import by.epam.library.parser.ParametersParser;
import by.epam.library.publicationtype.PublicationType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LibraryFactory {
    private static final Logger LOGGER = LogManager.getLogger(LibraryFactory.class);

    public Library makeLibrary(List<String> lines) {

        Library library = new Library();
        BookFactory bookFactory = new BookFactory();
        MagazineFactory magazineFactory = new MagazineFactory();
        PublicationType type;
        List<String> list;
        int lineIndex = 0;
        for (String line : lines) {
            lineIndex++;
            list = ParametersParser.parse(line);
            try {
                type = PublicationType.valueOf(list.get(0));
                switch (type) {
                    case BOOK:
                        library.add(bookFactory.getPublication(list));
                        break;
                    case MAGAZINE:
                        library.add(magazineFactory.getPublication(list));
                        break;
                }
            } catch (IllegalArgumentException ex) {
                LOGGER.log(Level.ERROR, "Can't define publication type at line" + lineIndex + ex);
            } catch (PublicationFormatException | PublicationLogicException ex) {
                LOGGER.log(Level.ERROR, ex + ": at line" + lineIndex);
            }
        }
        return library;
    }
}
