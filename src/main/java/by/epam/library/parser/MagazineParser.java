package by.epam.library.parser;

import by.epam.library.entity.Magazine;
import by.epam.library.exception.PublicationFormatException;
import by.epam.library.exception.PublicationLogicException;
import by.epam.library.publicationtype.MagazinePeriod;
import by.epam.library.publicationtype.MagazineType;

import java.math.BigDecimal;
import java.util.List;

public class MagazineParser {
    public static Magazine parse(List<String> parameters) throws PublicationLogicException, PublicationFormatException {
        BigDecimal price;
        int pages;
        int volume;
        MagazinePeriod period;
        MagazineType magazineType;

        if (parameters.size() < 8) {
            throw new PublicationLogicException("The number of parameters is less than necessary");
        }
        try {
            price = new BigDecimal(parameters.get(3));
            pages = Integer.parseInt(parameters.get(4));
            volume = Integer.parseInt(parameters.get(5));
            period = MagazinePeriod.valueOf(parameters.get(6).toUpperCase());
            magazineType = MagazineType.valueOf(parameters.get(7).toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new PublicationFormatException("Incorrect data format");
        }

        if (price.compareTo(new BigDecimal("0")) <= 0) {
            throw new PublicationLogicException("The price can't be less than 0");
        }

        if (pages <= 1) {
            throw new PublicationLogicException("The number of pages can't be less than 1");
        }

        return new Magazine(parameters.get(1), parameters.get(2), price, pages, volume, period, magazineType);
    }
}

