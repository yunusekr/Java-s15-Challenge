package library;

import library.enums.Categories;

import java.util.Objects;

public class Book {
    private long id;
    private String name;
    private Categories category;
    private double price;
    private Author author;
    private boolean status;
    private String dateOfPurchase;


    public Book(long id, String name, Categories category, double price, Author author) {
        if(!Library.books.contains(this)){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.author = author;
        this.status = true;
        if(!author.getBooks().contains(name)){
            author.setBooks(name);
        }
            Library.books.add(this);

        if(!Library.authors.contains(author)){
            Library.authors.add(author);
        }
    }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean getStatus() {
        return status;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Categories getCategory() {
        return category;
    }

    public boolean isStatus() {
        return status;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", author=" + author +
                ", status=" + status +
                '}';
    }
}
