package db.bookDB;

import entities.Author;
import entities.Book;

import java.util.List;

/**
 * @author Sander Joos
 */
public class BookRepositoryRelationalDB implements IBookRepository {

    public BookRepositoryRelationalDB(){

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

//    public Author getAuthorByTitle(String title) {
//        return null;
//    }
//
//    public Author getAuthorByISBN(String ISBN) {
//        return null;
//    }

    public void addBook(Book book) {

    }

    public void deleteBook(String title) {

    }

    public void deleteBookByISBN(String ISBN) {

    }

    public void deleteBook(Book book) {

    }

    public void updateBook(Book book) {

    }

    public Book getBookById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteBook(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
