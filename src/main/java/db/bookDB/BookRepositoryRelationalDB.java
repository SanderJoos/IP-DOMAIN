package db.bookDB;

import Exceptions.DatabaseException;
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
    
     public BookRepositoryRelationalDB(String name){
        factory=Persistence.createEntityManagerFactory(name);
    }
    
   public void closeConnection() throws DatabaseException{
        try{
            factory.close();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
    }
   
    public void closeManager() throws DatabaseException{
       try{
           manager.close();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
    }
    
    public void openConnection(){
        try {
            manager = factory.createEntityManager();
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<Book> getAllBooks() {
        try{
            this.openConnection();
            Query query = manager.createQuery("select b from Book b");
            return query.getResultList();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public Book getBook(String title) {
        try{
            this.openConnection();
            TypedQuery<Book> query = manager.createQuery("select b from Book b where b.title = :title", Book.class);
            return query.setParameter("title",title).getSingleResult();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public Book getBookByISBN(String ISBN) {
        try{
            this.openConnection();
            TypedQuery<Book> query = manager.createQuery("select b from Book b where b.ISBN = :ISBN", Book.class);
            return query.setParameter("ISBN",ISBN).getSingleResult();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
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
            this.openConnection();
            manager.getTransaction().begin();
            manager.persist(book);
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
           manager.getTransaction().rollback();
           throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public void deleteBook(String title) {
        try{
            this.openConnection();
            TypedQuery<Book> query = manager.createQuery("select b from Book b where b.title = :title", Book.class);
            Book book = query.setParameter("title",title).getSingleResult();
            manager.getTransaction().begin();
            manager.remove(book);
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
           manager.getTransaction().rollback();
           throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public void deleteBookByISBN(String ISBN) {
        try{
            this.openConnection();
            TypedQuery<Book> query = manager.createQuery("select b from Book b where b.ISBN = :ISBN", Book.class);
            Book book = query.setParameter("ISBN",ISBN).getSingleResult();
            manager.getTransaction().begin();
            manager.remove(book);
            manager.flush();
            manager.getTransaction().commit();
        }
       catch(Exception e){
           manager.getTransaction().rollback();
           throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public void deleteBook(Book book) {
        try{
            this.openConnection();
            manager.getTransaction().begin();
            manager.remove(book);
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
           manager.getTransaction().rollback();
           throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public void updateBook(Book book) {
        try{
            this.openConnection();
            manager.getTransaction().begin();
            manager.merge(book);
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
           manager.getTransaction().rollback();
           throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public Book getBookById(long id) {
        try{
            this.openConnection();
            return manager.find(Book.class, id);
        }
        catch(Exception e){
           manager.getTransaction().rollback();
           throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public void deleteBook(long id) {
        try{
            this.openConnection();
            Book b = this.manager.find(Book.class, id);
            manager.getTransaction().begin();
            manager.remove(b);
            manager.getTransaction().commit();
        }
        catch(Exception e){
           manager.getTransaction().rollback();
           throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }
}
