package db.bookDB;

import entities.Author;
import entities.Book;

import java.util.List;

/**
 * @author Sander Joos
 */
public interface IBookRepository {

    List<Book> getAllBooks();
    Book getBook(String title);
    Book getBookByISBN(String ISBN);
//    Author getAuthorByTitle(String title);
//    Author getAuthorByISBN(String ISBN);
    void addBook(Book book);
    void deleteBook(String title);
    void deleteBookByISBN(String ISBN);
    void deleteBook(Book book);

    void updateBook(Book book);
    Book getBookById(long id);
    void deleteBook(long id);
}
