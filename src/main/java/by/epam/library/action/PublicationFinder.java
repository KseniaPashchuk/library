package by.epam.library.action;

import by.epam.library.collection.Library;
import by.epam.library.entity.Publication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PublicationFinder {
    public static List<Publication> findByPrice(BigDecimal from, BigDecimal to, Library library) {
        List<Publication> foundList = new ArrayList<>();
        for (Publication p : library.getLibrary()) {
            if ((p.getPrice().compareTo(from) >= 0) && (p.getPrice().compareTo(to) <= 0)) {
                foundList.add(p);
            }
        }
        return foundList;
    }
}
