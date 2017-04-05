package by.epam.library.parser;

import by.epam.library.entity.Book;
import by.epam.library.exception.PublicationFormatException;
import by.epam.library.exception.PublicationLogicException;
import by.epam.library.publicationtype.BookType;

import java.math.BigDecimal;
import java.util.List;

public class BookParser {
    public static Book parse(List<String> parameters) throws PublicationFormatException, PublicationLogicException {
        BigDecimal price;
        int pages;
        BookType bookType;

        if (parameters.size() < 7) {
            throw new PublicationLogicException("The number of parameters is less than necessary");
        }
        try {
            price = new BigDecimal(parameters.get(3));
            pages = Integer.parseInt(parameters.get(4));
            bookType = BookType.valueOf(parameters.get(6));
        } catch (IllegalArgumentException ex) {
            throw new PublicationFormatException("Incorrect data format");
        }

        if (price.compareTo(new BigDecimal("0")) <= 0) {
            throw new PublicationLogicException("The price can't be less than 0");
        }

        if (pages <= 1) {
            throw new PublicationLogicException("The number of pages can't be less than 1");
        }
        return new Book(parameters.get(1), parameters.get(2), price, pages, parameters.get(5), bookType);
    }
}

