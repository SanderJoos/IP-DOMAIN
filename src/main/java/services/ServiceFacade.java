package services;

import db.actorDB.IAuthorRepository;
import db.bookDB.IBookRepository;
import entities.Author;
import entities.Book;

import java.util.List;

/**
 * @author Sander Joos
 */
public class ServiceFacade{

    AuthorService authorService;
    BookService bookService;

    public ServiceFacade(){
        this.authorService = new AuthorService();
        this.bookService = new BookService();
    }

    public List<Author> getAllAuthors() {
        return this.authorService.getAllAuthors();
    }

    public Author getAuthor(String name, String lastName) {
        return this.authorService.getAuthor(name,lastName);
    }

    public List<Book> getBooksFromAuthor(String name, String lastName) {
        return this.authorService.getBooksFromAuthor(name,lastName);
    }

    public List<Book> getBooksFromAuthor(String lastName) {
        return this.authorService.getBooksFromAuthor(lastName);
    }

    public void addAuthor(Author author) {
        this.authorService.addAuthor(author);
    }

    public void deleteAuthor(Author author) {
        this.authorService.deleteAuthor(author);
    }

    public void deleteAuthor(String lastName) {
        this.authorService.deleteAuthor(lastName);
    }

    public Author getAuthor(String lastName){
        return this.authorService.getAuthor(lastName);
    }

    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    public Book getBook(String title) {
        return this.bookService.getBook(title);
    }

    public Book getBookByISBN(String ISBN) {
        return this.bookService.getBookByISBN(ISBN);
    }

    public Author getAuthorByTitle(String title) {
        return this.bookService.getAuthor(title);
    }

    public Author getAuthorByISBN(String ISBN) {
        return this.bookService.getAuthorByISBN(ISBN);
    }

    public void addBook(Book book) {
        this.bookService.addBook(book);
    }

    public void deleteBook(String title) {
        this.bookService.deleteBook(title);
    }

    public void deleteBookByISBN(String ISBN) {
        this.bookService.deleteBookByISBN(ISBN);
    }

    public void deleteBook(Book book) {
        this.bookService.deleteBook(book);
    }

    public double getAverageScoreForAuthor(String lastName){
        Author author = this.authorService.getAuthor(lastName);
        return author.getAverageScore();
    }

    public void addBookToAuthor(Author author, Book book){
        author.addBook(book);
    }
}
