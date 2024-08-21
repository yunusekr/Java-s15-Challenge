package library;

import library.enums.Categories;

import java.util.Objects;

public abstract class Person  {
    private long id;
    private String name;
    private String surName;

    public Person(long id,String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public void showAll(){
        for(Book books:Library.books){
            System.out.println(books);
        }
    }

    public void showAll(Categories category){
        Library.books.stream().filter(l-> l.getCategory() == category).forEach(l -> System.out.println(l));
    }

    public void showAll(Author author){
        Library.books.stream().filter(l-> l.getAuthor() == author).forEach(l -> System.out.println(l));
    }

    public void showAll(String name){
        if(Library.books.stream().filter(l-> l.getName().equals(name)).toList().isEmpty()){
            System.out.println("Kitap Bulunamadı");
        }
      Library.books.stream().filter(l-> l.getName().equals(name)).forEach(l -> System.out.println(l));
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(surName, person.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surName);
    }
}
