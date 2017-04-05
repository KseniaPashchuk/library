package by.epam.library.factory.publicationfactory;

import by.epam.library.entity.Book;
import by.epam.library.exception.PublicationFormatException;
import by.epam.library.exception.PublicationLogicException;
import by.epam.library.parser.BookParser;

import java.util.List;

public class BookFactory extends AbstractPublicationFactory {
    @Override
    public Book getPublication(List<String> parameters) throws PublicationFormatException, PublicationLogicException {
        return BookParser.parse(parameters);
    }
}
