package by.epam.library.action;


import by.epam.library.collection.Library;
import by.epam.library.entity.Publication;
import by.epam.library.publicationtype.PublicationType;

import java.util.List;

public class PageCounter {
    public static int count(PublicationType type, Library library) {
        int pages = 0;
        for (Publication p : library.getLibrary()) {
               if(p.getType().equals(type)){
                   pages += p.getPages();
               }
        }
        return pages;
    }
}
