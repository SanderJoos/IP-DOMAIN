package db.bookDB;

import entities.Author;
import entities.Book;

import java.util.List;

/**
 * @author Sander Joos
 */
public class BookRepositoryPostgresql implements IBookRepository {

    public BookRepositoryPostgresql(){

    }

    public List<Book> getAllBooks() {
        return null;
    }

    public Book getBook(String title) {
        return null;
    }

    public Book getBookByISBN(String ISBN) {
        return null;
    }

    public Author getAuthorByTitle(String title) {
        return null;
    }

    public Author getAuthorByISBN(String ISBN) {
        return null;
    }

    public void addBook(Book book) {

    }

    public void deleteBook(String title) {

    }

    public void deleteBookByISBN(String ISBN) {

    }

    public void deleteBook(Book book) {

    }
}
