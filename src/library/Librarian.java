package library;

import library.Interfaces.IAddable;
import library.Interfaces.IInvoicable;
import library.Interfaces.Iremovable;
import library.enums.Categories;

import java.util.Optional;

public class Librarian extends Person implements IAddable, Iremovable, IInvoicable {
    private String password;
    public Librarian(long id,String name, String surName,String password) {
        super(id,name, surName);
        this.password = password;
        Library.librarians.put(id,this);
    }


    @Override
    public void addBook(long id, String name, Categories category, double price, Author realAuthor) {
        new Book(id,name,category,price,realAuthor);
    }

    @Override
    public void removeBook(long id) {
        Optional<Book> bookToRemove = Library.books.stream()
                .filter(a -> a.getId() == id)
                .findFirst();

        if (bookToRemove.isPresent()) {
            Library.books.remove(bookToRemove.get());
            System.out.println("Kitap Silindi");
        } else {
            System.out.println("Kitap Bulunamadı");
        }
    }


    @Override
    public void invoice(Book chosenBook,Person p) {
        Bill.bills.put(chosenBook,p);
    }
}
