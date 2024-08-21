import library.*;
import library.enums.Categories;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Librarian(1, "Semih", "Kılıçsoy", "d1");
        new Librarian(2, "Salih", "Uçan", "d2");
        new Librarian(3, "Mert", "Günok", "d2");
        new Librarian(4, "Onur", "Bulut", "d2");

        new Reader(1, "Mehmet", "Özdilek");
        new Reader(2, "Burak", "Yılmaz");
        new Student(3, "Ahmet", "Kara");
        new Faculty(4, "Deneme", "Fakülte");

        Author author = new Author(1, "Yunus", "Eker");
        Author author2 = new Author(2, "Özdemir", "Asaf");

        Book book = new Book(1, "deneme", Categories.JOURNALS, 100, author);
        Book book1 = new Book(2, "deneme8", Categories.JOURNALS, 100, author);
        Book book2 = new Book(3, "deneme", Categories.JOURNALS, 100, author);
        Book book3 = new Book(4, "deneme3", Categories.STUDY_BOOKS, 50, author2);
        Book book4 = new Book(5, "deneme3", Categories.STUDY_BOOKS, 50, author2);
        Book book5 = new Book(6, "deneme5", Categories.STUDY_BOOKS, 50, author2);
        Book book6 = new Book(7, "deneme6", Categories.STUDY_BOOKS, 50, author2);
        Book book7 = new Book(8, "deneme7", Categories.STUDY_BOOKS, 50, author2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Giriş yapan kişinin konumunu seçin:");
        System.out.println("1.Kütüphane Görevlisi");
        System.out.println("2.Okuyucu");
        int num = scanner.nextInt();
        if (num == 1) {
            Library.librarians.forEach((key, value) -> System.out.println(key + "." + Library.librarians.get(key).getName() + " " + Library.librarians.get(key).getSurName()));
            System.out.println("Giriş yapan kişiyi seçin:");
            long num1 = scanner.nextLong();
            runProgram(Library.librarians.get(num1), null);
        } else if (num == 2) {
            Library.readers.forEach((key, value) -> System.out.println(key + "." + Library.readers.get(key).getName() + " " + Library.readers.get(key).getSurName()));
            System.out.println("Giriş yapan kişiyi seçin:");
            long num2 = scanner.nextLong();
            Random random = new Random();
            long randomNumber = 1 + (random.nextInt(Library.librarians.size()));
            runProgram(Library.readers.get(num2),Library.librarians.get(randomNumber));
        }
    }

    public static void runProgram(Person person1, Person person2) {


        boolean again = true;
        while (again) {
            Scanner scanner = new Scanner(System.in);

            if(person1 instanceof Librarian) {
                System.out.println("1: Tüm Kitapları Listele");
                System.out.println("2: Kategoriye Göre Kitapları Listele");
                System.out.println("3: Yazara Göre Kitapları Listele");
                System.out.println("4: İsime Göre Kitapları Listele");
                System.out.println("5: Kitap Ekle");
                System.out.println("6: Kitap Sil");
                System.out.println("0: Çıkış");

            }else{
                System.out.println("1: Tüm Kitapları Listele");
                System.out.println("2: Kategoriye Kitapları Göre Listele");
                System.out.println("3: Yazara Kitapları Göre Listele");
                System.out.println("4: İsime Göre Kitapları Listele");
                System.out.println("7: Kitap Al");
                System.out.println("8: Kitap İade Et");
                System.out.println("0: Çıkış");

            }

            System.out.println("Lütfen işlem numarası girin:");

            int islemNumarasi = scanner.nextInt();
            scanner.nextLine();

            switch (islemNumarasi) {
                case 0:
                    System.out.println("Program sonlanıyor...");
                    again = false;
                    System.exit(0);
                case 5:
                    long id = Library.books.size() + 1;
                    System.out.println("Lütfen kitap ismini giriniz:");
                    String name = scanner.nextLine();
                    System.out.println("Lütfen kitabın kategorisini seçin:");
                    for (Categories cat : Categories.values()) {
                        System.out.println((cat.ordinal() + 1) + "." + cat);
                    }
                    Categories category = Categories.values()[Integer.parseInt(scanner.next()) - 1];
                    System.out.println("Lütfen kitabın fiyatını giriniz: ");
                    double price = Double.parseDouble(scanner.next());
                    System.out.println("Lütfen kitabının yazarının adını giriniz: ");
                    String authorName = scanner.next();
                    System.out.println("Lütfen kitabının yazarının soyadını giriniz: ");
                    String authorSurname = scanner.next();
                    List<Author> auts = Library.authors.stream().filter(a -> a.getName().equals(authorName) && a.getSurName().equals(authorSurname)).toList();
                    Author realAuthor;
                    if (!auts.isEmpty()) {
                        realAuthor = auts.get(0);
                    } else {
                        realAuthor = new Author(Library.authors.size() + 1, authorName, authorSurname);
                    }
                    ((Librarian) person1).addBook(id, name, category, price, realAuthor);
                    System.out.println("Kitap eklendi");
                    break;

                case 6:
                    System.out.println("Lütfen silmek istediğiniz kitabın id'sini giriniz: ");
                    long removeId = Long.parseLong(scanner.next());

                    ((Librarian)person1).removeBook(removeId);

                    break;
                case 1:
                     person1.showAll();
                    break;
                case 2:
                    System.out.println("Lütfen Listelemek istediğiniz kitapların kategorisini seçin:");
                    for (Categories cat : Categories.values()) {
                        System.out.println((cat.ordinal() + 1) + "." + cat);
                    }
                    Categories category1 = Categories.values()[Integer.parseInt(scanner.next()) - 1];
                    person1.showAll(category1);
                    break;
                case 3:
                    System.out.println("Lütfen Listelemek istediğiniz kitapların yazarını seçin:");

                    int count = 1;
                    for (Author auths1 : Library.authors) {
                        System.out.println(count + "." + auths1.getName() + " " + auths1.getSurName());
                        count++;
                    }
                    long authid = scanner.nextLong();
                    Author author1 = Library.authors.stream().filter(l -> l.getId() == authid).findFirst().get();
                    person1.showAll(author1);
                    break;
                case 7:
                    System.out.println("Lütfen ödünç almak istediğiniz kitabın id'sini giriniz:");
                    long chosenId = Long.parseLong(scanner.next());
                    Book chosenBook = Library.books.stream().filter(l -> l.getId() == chosenId).findFirst().get();
                    if(chosenBook.getStatus() && chosenBook.getDateOfPurchase() == null){
                            if (!((Reader) person1).getBooks().stream().filter(c -> c.getName().equals(chosenBook.getName())).toList().isEmpty()) {
                                System.out.println("Bu kitap sizde zaten mevcut");
                            } else {
                                if (((Reader) person1).getBooks().size() < 5) {
                                    ((Reader) person1).addBooks(chosenBook);
                                    LocalDateTime now = LocalDateTime.now();
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                                    String formattedDateTime = now.format(formatter);
                                    chosenBook.setDateOfPurchase(formattedDateTime);
                                    chosenBook.setStatus(false);
                                    ((Librarian)person2).invoice(chosenBook,person1);
                                } else {
                                    System.out.println("5 adet kitaba sahipsizin 5 adetten fazla kitap alınamaz");
                                }
                            }
                        }else {
                        System.out.println("Bu kitap " + chosenBook.getDateOfPurchase() + " tarihinde" + " " + Bill.bills.get(chosenBook).getName() + " " + Bill.bills.get(chosenBook).getSurName() + " tarafından alınmıştır.");
                    }

                    break;
                case 4:
                    System.out.println("Lütfen Listelemek istediğiniz kitabın ismini giriniz:");
                    String bookName = scanner.nextLine();
                    person1.showAll(bookName);
                    break;
                case 8:
                    ((Reader) person1).getBooks().stream().forEach(System.out::println);
                    System.out.println("Lütfen listenizden iade etmek istediğiniz kitabın id'sini giriniz:");
                    long chosenBackId = Long.parseLong(scanner.next());
                    Book chosenBackBook = ((Reader) person1).getBooks().stream().filter(l -> l.getId() == chosenBackId).findFirst().get();
                    ((Reader) person1).getBooks().remove(chosenBackBook);
                    Bill.bills.remove(chosenBackBook);
                    chosenBackBook.setStatus(true);
                    chosenBackBook.setDateOfPurchase(null);
                    System.out.println(chosenBackBook.getPrice() + " değerinde olan ücretiniz iade edilmiştir");
                    break;
                
                default:
                    System.out.println("Geçersiz işlem numarası.");
            }
        }
    }
}



