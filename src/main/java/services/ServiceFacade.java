package services;

import entities.Author;
import entities.Book;
import rest.entities.AGOTBookLibrary;

import java.util.ArrayList;
import java.util.List;
import rest.entities.AGOTBook;

/**
 * @author Sander Joos
 */
public class ServiceFacade{

    AuthorService authorService;
    BookService bookService;
    
    AGOTBookLibrary AGOTBooks;

    public ServiceFacade(String repositoryKind){
        this.authorService = new AuthorService(repositoryKind);
        this.bookService = new BookService(repositoryKind);
        this.AGOTBooks = new AGOTBookLibrary();
    }
       
    public void closeConnection(){
        this.bookService.getRepository().closeConnection();
        this.authorService.getAuthorRepository().closeConnection();
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

//    public Author getAuthorByTitle(String title) {
//        return this.bookService.getAuthor(title);
//    }
//
//    public Author getAuthorByISBN(String ISBN) {
//        return this.bookService.getAuthorByISBN(ISBN);
//    }

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

    public void updateAuthor(Author author){
        this.authorService.updateAuthor(author);
    }

    public Author getAuthorById(long id){
        return this.authorService.getAuthorById(id);
    }

    public void deleteAuthor(long id){
        this.authorService.deleteAuthor(id);
    }

    public void updateBook(Book book){
        this.bookService.updateBook(book);
    }
    
    public Book getBookById(long id){
        return this.bookService.getBookById(id);
    }
    
    public void deleteBook(long id){
        this.bookService.deleteBook(id);
    }
    
    public List<String> getAllBookTitles(){
        List<String> titles = new ArrayList<String>();
        for(Book b : this.getAllBooks()){
            titles.add(b.getTitle());
        }
        return titles;
    }
    
    public String printAGOTBookLibrary(){
        return this.AGOTBooks.toString();
    }
    
    public List<AGOTBook> getAGOTBooks(){
        return this.AGOTBooks.getAGOTBooks();
    }
    
    public AGOTBookLibrary getAGOTBookLibrary(){
        return this.AGOTBooks;
    }
}
