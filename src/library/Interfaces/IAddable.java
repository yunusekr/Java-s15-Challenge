package library.Interfaces;

import library.Author;
import library.enums.Categories;

public interface IAddable {
    void addBook(long id, String name, Categories category, double price, Author realAuthor);
}
