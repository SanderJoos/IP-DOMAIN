package db.bookDB;

import Exceptions.DatabaseException;
import entities.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sander Joos
 */
public class BookRepositoryInMemory implements IBookRepository {
    
    private static int counter = 0;

    private static Map<Long, Book> booksById;

    public BookRepositoryInMemory(){
        this.booksById = new HashMap<Long, Book>();
    }
    
    public Book getBookById(long id){
       return this.booksById.get(id);
    }
    
    public List<Book> getAllBooks() {
        return new ArrayList<Book>(this.booksById.values());
    }
    
     public static int getNextID(){
        counter++;
        return counter;
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
         List<Book> books = this.getAllBooks();
        for (Book b : books) {
            if (b.getISBN().equals(ISBN)) {
                return b;
            }
        }
        return null;
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
        this.booksById.remove(book.getId());
    }

    public void deleteBook(Book book) {
        if(book == null){
            throw new DatabaseException("Book can't be found");
        }
        this.booksById.remove(book.getId());
    }

    public void deleteBookByISBN(String ISBN) {
        if(ISBN.isEmpty()){
            throw new DatabaseException("Book can't be found based on an empty ISBN");
        }
        Book book = this.getBookByISBN(ISBN);
        this.booksById.remove(book.getId());
    }

    public void addBook(Book book) {
        if(book == null){
            throw new DatabaseException("Book can't be added because it doesn't exist");
        }
        book.setId(BookRepositoryInMemory.getNextID());
        this.booksById.put(book.getId(), book);
    }

    public void updateBook(Book book) {
        if(book == null){
            throw new DatabaseException("We can't update a book if we don't know which one");
        }
        this.deleteBook(book);
        this.booksById.put(book.getId(), book);
    }

    public void deleteBook(long id) {
       this.booksById.remove(id);
    }

    public void closeConnection() {
       System.out.println("I iz hashmap");
    }
}
