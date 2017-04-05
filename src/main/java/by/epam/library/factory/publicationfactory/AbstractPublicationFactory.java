package by.epam.library.factory.publicationfactory;

import by.epam.library.entity.Publication;
import by.epam.library.exception.PublicationFormatException;
import by.epam.library.exception.PublicationLogicException;

import java.util.List;

public abstract class AbstractPublicationFactory {
    public abstract Publication getPublication(List<String> parameters) throws PublicationFormatException, PublicationLogicException;
}
