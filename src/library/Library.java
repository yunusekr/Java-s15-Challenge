package library;

import java.util.*;

public abstract class Library{
    public static List<Book> books = new LinkedList<>();
    public static Set<Author> authors = new TreeSet<>();
    public static Map<Long, Reader> readers = new HashMap<>();
    public static Map<Long, Librarian> librarians = new HashMap<>();
}
