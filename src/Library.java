import java.util.ArrayList;

public class Library {


    private ArrayList<Book> library = new ArrayList<>();

    public void addBook(Book book) {
        library.add(book);
    }

    public String findBookByName(String name) {
        for (Book book : library) {
            if (book.getName().equals(name)) {
                return book.toString();
            }
        }
        return ("Boken hittades inte");
    }

    public String availableBooks() {
        String returnMessage = "";
        for (Book book : library) {
            if (book.isAvailable()) {
            returnMessage += book.toString() + "\n";
            }
        } if (returnMessage.equals("")) {
        returnMessage = "Inga böcker är tillgängliga";
        } return returnMessage;
    }




    public Book findBook(String name) {
        for (Book book : library) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }


    }




