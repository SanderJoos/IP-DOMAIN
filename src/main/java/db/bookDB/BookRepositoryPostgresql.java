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

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book getBook(String title) {
        return null;
    }

    @Override
    public Book getBookByISBN(String ISBN) {
        return null;
    }

    @Override
    public Author getAuthorByTitle(String title) {
        return null;
    }

    @Override
    public Author getAuthorByISBN(String ISBN) {
        return null;
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void deleteBook(String title) {

    }

    @Override
    public void deleteBookByISBN(String ISBN) {

    }

    @Override
    public void deleteBook(Book book) {

    }
}
