package services;

import db.bookDB.BookRepositoryFactory;
import db.bookDB.IBookRepository;
import entities.Author;
import entities.Book;

import java.util.List;

/**
 * @author Sander Joos
 */
public class BookService{

    IBookRepository repository;

    public BookService(String repositoryKind){
        this.repository = new BookRepositoryFactory().getBookRepository(repositoryKind);
    }

    public IBookRepository getRepository() {
        return repository;
    }

    public void setRepository(String bookRepositoryKind) {
        //TODO
        this.repository = new BookRepositoryFactory().getBookRepository(bookRepositoryKind);
    }

    public List<Book> getAllBooks() {
        return this.getRepository().getAllBooks();
    }

    public Book getBook(String title) {
        return this.getRepository().getBook(title);
    }

    public Book getBookByISBN(String ISBN) {
        return this.getRepository().getBookByISBN(ISBN);
    }

    public Author getAuthor(String title) {
       return this.getRepository().getAuthorByTitle(title);
    }

    public Author getAuthorByISBN(String ISBN) {
        return this.getRepository().getAuthorByISBN(ISBN);
    }

    public void addBook(Book book) {
        this.getRepository().addBook(book);
    }

    public void deleteBook(String title) {
        this.getRepository().deleteBook(title);
    }

    public void deleteBookByISBN(String ISBN) {
        this.getRepository().deleteBookByISBN(ISBN);
    }

    public void deleteBook(Book book) {
        this.getRepository().deleteBook(book);
    }
}
