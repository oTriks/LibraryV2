import java.util.ArrayList;

// this class creates a library of books from Book class and contains methods
public class Library {


    private ArrayList<Book> library = new ArrayList<>();


    // adds book to library
    public void addBook(Book book) {
        library.add(book);
    }

    //   finds book by name and returns a string with book information
    public String findBookByName(String name) {
        for (Book book : library) {
            if (book.getName().equals(name)) {
                return book.toString();
            }
        }
        return ("Boken hittades inte");
    }


    // return string with information about available books
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



// finds book based by name and returns book object if found
    public Book findBook(String name) {
        for (Book book : library) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }


    }




