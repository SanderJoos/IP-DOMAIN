package db.bookDB;

import entities.Author;
import entities.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sander Joos
 */
public class BookRepositoryHashMap implements IBookRepository {

    private Map<String, Book> bookByTitle = new HashMap<String, Book>();
    private Map<String, Book> bookByISBN = new HashMap<String, Book>();

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<Book>(this.bookByTitle.values());
    }

    @Override
    public Book getBook(String title) {
        return this.bookByTitle.get(title);
    }

    @Override
    public Book getBookByISBN(String ISBN) {
        return this.bookByISBN.get(ISBN);
    }

    @Override
    public Author getAuthorByTitle(String title) {
        return this.bookByTitle.get(title).getAuthor();
    }

    @Override
    public Author getAuthorByISBN(String ISBN) {
        return this.bookByISBN.get(ISBN).getAuthor();
    }

    @Override
    public void deleteBook(String title) {
        Book book = this.getBook(title);
        this.bookByISBN.remove(book.getISBN());
        this.bookByTitle.remove(book.getTitle());
    }

    @Override
    public void deleteBook(Book book) {
        this.bookByISBN.remove(book.getISBN());
        this.bookByTitle.remove(book.getTitle());
    }

    @Override
    public void deleteBookByISBN(String ISBN) {
        Book book = this.getBookByISBN(ISBN);
        this.bookByISBN.remove(book.getISBN());
        this.bookByTitle.remove(book.getTitle());
    }

    @Override
    public void addBook(Book book) {
        this.bookByISBN.put(book.getISBN(), book);
        this.bookByTitle.put(book.getTitle(), book);
    }
}
