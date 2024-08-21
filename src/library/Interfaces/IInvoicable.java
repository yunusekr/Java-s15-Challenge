package library.Interfaces;

import library.Book;
import library.Person;

public interface IInvoicable {
    void invoice(Book chosenBook, Person p);
}
