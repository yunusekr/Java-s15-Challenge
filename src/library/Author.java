package library;

import java.util.LinkedList;
import java.util.List;

public class Author extends Person implements Comparable<Author> {

    private List<String> books = new LinkedList<>();

    public Author(long id,String name, String surName) {
        super(id,name,surName);
        Library.authors.add(this);
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(String book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public int compareTo(Author o) {
        return Long.compare(this.getId(), o.getId());
    }
}
