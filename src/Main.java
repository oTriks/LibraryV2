import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        Library library = new Library();

        Book book1 = new Book("golf", "kajsa", 2000, 1.2);
        Book book2 = new Book("tennis", "anna", 2003, 1.8);
        Book book3 = new Book("fotboll", "pär", 2002, 1.2);
        Book book4 = new Book("hockey", "emil", 2001, 1.5);
        Book book5 = new Book("bandy", "olof", 2006, 1.2);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);


        do {
            System.out.println("1. Lägg till en bok \n2. Sök efter en bok \n3. Se tillgängliga böcker \n4. Returnera en bok \n5. Låna en bok\n6. Avsluta");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Ange namn:");
                    String name = sc.nextLine();
                    System.out.println("Ange författare:");
                    String author = sc.nextLine();
                    System.out.println("Ange årtal:");
                    int year = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ange upplaga:");
                    int edition = sc.nextInt();
                    sc.nextLine();
                    Book newBook = new Book(name, author, year, edition);
                    library.addBook(newBook);
                    break;
                case 2:
                    System.out.println("Vilken bok söker du?");
                    String input = sc.nextLine();
                    String bookInfo = library.findBookByName(input);
                    System.out.println(bookInfo);
                    break;
                case 3:
                    String availableBooks = library.availableBooks();
                    System.out.println(availableBooks);
                    break;
                case 4:
                    System.out.println("Vilken bok vill du lämna tillbaka?");
                    String bookName = sc.nextLine();
                    Book foundBook = library.findBook(bookName);
                    if (foundBook != null) {
                        boolean status = foundBook.isAvailable();
                        if (!status) {
                            foundBook.returnBook();
                            System.out.println("Tack för din retur!");
                        } else {
                            System.out.println("Boken är inte utlånad och kan därför inte lämnas tillbaka!");
                        }
                    } else {
                        System.out.println("Boken finns inte i vårt system!");
                    }
                    break;
                case 5:
                    System.out.println("Vilken bok vill du låna?");
                    String loanName = sc.nextLine();
                    Book chosenBook = library.findBook(loanName);
                    boolean available = chosenBook.isAvailable();
                    if (available) {
                        chosenBook.loan();
                        System.out.println("Tack för att du lånat!");
                    } else {
                        System.out.println("Boken är utlånad!");
                    }
                    break;
                case 6:
                    System.out.println("Hejdå!");
                    break;
            }
        } while (choice != 6);
    }
}