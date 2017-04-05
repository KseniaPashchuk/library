package by.epam.library.factory.publicationfactory;

import by.epam.library.entity.Magazine;
import by.epam.library.exception.PublicationFormatException;
import by.epam.library.exception.PublicationLogicException;
import by.epam.library.factory.publicationfactory.AbstractPublicationFactory;
import by.epam.library.parser.MagazineParser;

import java.util.List;

public class MagazineFactory extends AbstractPublicationFactory {

    @Override
    public Magazine getPublication(List<String> parameters) throws PublicationFormatException, PublicationLogicException {
        return MagazineParser.parse(parameters);
    }
}
