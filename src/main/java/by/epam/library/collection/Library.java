package by.epam.library.collection;

import by.epam.library.entity.Publication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<Publication> library;

    public Library() {
        library = new ArrayList<>();
    }

    public Library(List<Publication> library) {
        this.library = library;
    }

    public Publication getByIndex(int index) {
        return library.get(index);
    }

    public List<Publication> getLibrary() { // нужна сортировка
        return library;
    }

    public void add(Publication p) {
        library.add(p);
    }
    public void remove(Publication p) {
        if(library.contains(p)){
            library.remove(p);
        }
    }
    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        for (Publication p : library) {
            str.append(p);
            str.append("\n");
        }
        return str.toString();
    }
}
