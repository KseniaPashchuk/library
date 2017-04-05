package by.epam.library.action;

import by.epam.library.collection.Library;
import by.epam.library.entity.Publication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PublicationSorter {

    public static void sortByName(Library library) {
        library.getLibrary().sort(Comparator.comparing(Publication::getName));
    }

    public static void sortByTypeAndName(Library library) {
        library.getLibrary().sort(Comparator.comparing(Publication::getType).thenComparing(Publication::getName));
    }

    public static void sortByTypeAndPrice(Library library) {
        library.getLibrary().sort(Comparator.comparing(Publication::getType).thenComparing(Publication::getPrice));
    }
}
