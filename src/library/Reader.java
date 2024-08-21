package library;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Reader extends Person {

    private Set<Book> books = new HashSet<>();

    public Reader(long id,String name, String surName) {
        super(id,name, surName);
        Library.readers.put(id,this);
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addBooks(Book addingBooks) {
        books.add(addingBooks);
    }


}
