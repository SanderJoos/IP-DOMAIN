package db.actorDB;

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
public class AuthorRepositoryRelationalDB extends DatabaseConnection implements IAuthorRepository {

    private EntityManagerFactory factory;
    private EntityManager manager;

    public AuthorRepositoryRelationalDB(String name){
        factory=Persistence.createEntityManagerFactory(name);
        manager = factory.createEntityManager();
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
        } 
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Author getAuthor(String lastName) {
        try{
            this.openConnection();
            TypedQuery<Author> query = manager.createQuery("select a from Author a where a.lastName  = :lastName", Author.class);
            return query.setParameter("lastName", lastName).getSingleResult();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public List<Book> getBooksFromAuthor(String name, String lastName) {
        return this.getBooksFromAuthor(lastName);
    }

    public List<Book> getBooksFromAuthor(String lastName) {
        try{
            this.openConnection();
            TypedQuery<Author> query = manager.createQuery("select a from Author a where a.lastName = :lastName", Author.class);
            return query.setParameter("lastName", lastName).getSingleResult().getBooks();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public void addAuthor(Author author) throws DatabaseException{
        try{
            this.openConnection();
            manager.getTransaction().begin();
            manager.persist(author);
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public void deleteAuthor(Author author) {
        try{
            this.openConnection();
            manager.getTransaction().begin();
            manager.remove(author);
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public void deleteAuthor(String lastName) {
        try{
            this.openConnection();
            Query query = manager.createQuery("delete from Author a where a.lastName = :lastName");
            query.setParameter("lastName",lastName).executeUpdate();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public List<Author> getAllAuthors() {
        try{
            this.openConnection();
            Query query = manager.createQuery("select a from Author a");
            return query.getResultList();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public Author getAuthor(String name, String lastName) {
        try{
            this.openConnection();
            return this.getAuthor(lastName);
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public void updateAuthor(Author author) {
        try{
            //merge methode
            this.openConnection();
            manager.getTransaction().begin();
            manager.merge(author);
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public Author getAuthorById(long id) {
        try{
            this.openConnection();
            return manager.find(Author.class, id);
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }

    public void deleteAuthor(long id) {
        try{
            this.openConnection();
            Author author = this.manager.find(Author.class, id);
            manager.getTransaction().begin();
            manager.remove(author);
            manager.getTransaction().commit();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
        finally{
            this.closeManager();
        }
    }
}
