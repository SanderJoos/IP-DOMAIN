package db.bookDB;

import Exceptions.DatabaseException;
import entities.Author;
import entities.Book;
import javafx.scene.chart.PieChart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sander Joos
 */
public class BookRepositoryHashMap implements IBookRepository {

    private static Map<String, Book> bookByISBN = new HashMap<String, Book>();

    public List<Book> getAllBooks() {
        return new ArrayList<Book>(this.bookByISBN.values());
    }

    public Book getBook(String title) {
        if(title.isEmpty()){
            throw new DatabaseException("Book can't be found based on an empty title");
        }
        List<Book> books = this.getAllBooks();
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                return b;
            }
        }
        return null;
    }

    public Book getBookByISBN(String ISBN) {
        if(ISBN.isEmpty()){
            throw new DatabaseException("Book can't be found based on an empty ISBN number");
        }
        return this.bookByISBN.get(ISBN);
    }

//    public Author getAuthorByTitle(String title) {
//        return this.bookByTitle.get(title).getAuthor();
//    }
//
//    public Author getAuthorByISBN(String ISBN) {
//        return this.bookByISBN.get(ISBN).getAuthor();
//    }

    public void deleteBook(String title) {
        if(title.isEmpty()){
            throw new DatabaseException("Book can't be found based on an empty title");
        }
        Book book = this.getBook(title);
        this.bookByISBN.remove(book.getISBN());
    }

    public void deleteBook(Book book) {
        if(book == null){
            throw new DatabaseException("Book can't be found");
        }
        this.bookByISBN.remove(book.getISBN());
    }

    public void deleteBookByISBN(String ISBN) {
        if(ISBN.isEmpty()){
            throw new DatabaseException("Book can't be found based on an empty ISBN");
        }
        this.bookByISBN.remove(ISBN);
    }

    public void addBook(Book book) {
        if(book == null){
            throw new DatabaseException("Book can't be added because it doesn't exist");
        }
        this.bookByISBN.put(book.getISBN(), book);
    }

    public void updateBook(Book book) {
        if(book == null){
            throw new DatabaseException("We can't update a book if we don't know which one");
        }
        this.deleteBook(book);
        this.bookByISBN.put(book.getISBN(), book);
    }
}
