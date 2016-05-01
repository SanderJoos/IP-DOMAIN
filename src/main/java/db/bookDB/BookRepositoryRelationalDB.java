package db.bookDB;

import exceptions.DatabaseException;
import db.DatabaseConnection;
import entities.Author;
import entities.Book;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @author Sander Joos
 */
public class BookRepositoryRelationalDB extends DatabaseConnection implements IBookRepository {

    private EntityManagerFactory factory;
    private EntityManager manager;
    
   public void closeConnection() throws DatabaseException{
        try{
            manager.close();
            factory.close();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public BookRepositoryRelationalDB(String name){
        factory=Persistence.createEntityManagerFactory(name);
        manager = factory.createEntityManager();
    }

    public List<Book> getAllBooks() {
        try{
            Query query = manager.createQuery("select b from Book b");
            return query.getResultList();
        }
        catch(Exception e){
            this.closeConnection();
            throw new DatabaseException(e.getMessage());
        }
    }

    public Book getBook(String title) {
        try{
            TypedQuery<Book> query = manager.createQuery("select b from Book b where b.title = :title", Book.class);
            return query.setParameter("title",title).getSingleResult();
        }
        catch(Exception e){
            this.closeConnection();
            throw new DatabaseException(e.getMessage());
        }
    }

    public Book getBookByISBN(String ISBN) {
        try{
            TypedQuery<Book> query = manager.createQuery("select b from Book b where b.ISBN = :ISBN", Book.class);
            return query.setParameter("ISBN",ISBN).getSingleResult();
        }
        catch(Exception e){
            this.closeConnection();
            throw new DatabaseException(e.getMessage());
        }
    }

//    public Author getAuthorByTitle(String title) {
//        return null;
//    }
//
//    public Author getAuthorByISBN(String ISBN) {
//        return null;
//    }

    public void addBook(Book book) {
         try{
            manager.getTransaction().begin();
            manager.persist(book);
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
            manager.getTransaction().rollback();                     
            this.closeConnection();
            throw new DatabaseException(e.getMessage());
        }
    }

    public void deleteBook(String title) {
        Book book = this.getBook(title);
        try{
            manager.getTransaction().begin();
            manager.remove(book);
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
            this.closeConnection();
            throw new DatabaseException(e.getMessage());
        }
    }

    public void deleteBookByISBN(String ISBN) {
        Book book = this.getBookByISBN(ISBN);
        try{
            manager.getTransaction().begin();
            manager.remove(book);
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
            manager.getTransaction().rollback();
            this.closeConnection();
            throw new DatabaseException(e.getMessage());
        }
    }

    public void deleteBook(Book book) {
        try{
            manager.getTransaction().begin();
            manager.remove(book);
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
            manager.getTransaction().rollback();
            this.closeConnection();
            throw new DatabaseException(e.getMessage());
        }
    }

    public void updateBook(Book book) {
        try{
            manager.getTransaction().begin();
            Book b = this.getBookById(book.getId());
            b.setId(book.getId());
            b.setISBN(book.getISBN());
            b.setScore(book.getScore());
            b.setTitle(book.getTitle());
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
            manager.getTransaction().rollback();
            this.closeConnection();
            throw new DatabaseException(e.getMessage());
        }
    }

    public Book getBookById(long id) {
        try{
            return manager.find(Book.class, id);
        }
        catch(Exception e){
            this.closeConnection();
            throw new DatabaseException(e.getMessage());
        }
    }

    public void deleteBook(long id) {
        try{
            Book b = this.getBookById(id);
            this.deleteBook(b);
        }
        catch(Exception e){
            this.closeConnection();
            throw new DatabaseException(e.getMessage());
        }
    }
}
