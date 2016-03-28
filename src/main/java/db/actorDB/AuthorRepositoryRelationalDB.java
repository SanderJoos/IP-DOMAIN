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
            manager.close();
            factory.close();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Author getAuthor(String lastName) {
        return null;
    }

    public List<Book> getBooksFromAuthor(String name, String lastName) {
        return null;
    }

    public List<Book> getBooksFromAuthor(String lastName) {
        return null;
    }

    public void addAuthor(Author author) throws DatabaseException{
        try{
            manager.getTransaction().begin();
            manager.persist(author);
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public void deleteAuthor(Author author) {
        try{
            manager.getTransaction().begin();
            manager.remove(author);
            manager.flush();
            manager.getTransaction().commit();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public void deleteAuthor(String lastName) {

    }

    public List<Author> getAllAuthors() {
        try{
            Query query = manager.createQuery("select a from Author a");
            return query.getResultList();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Author getAuthor(String name, String lastName) {
        return null;
    }

    public void updateAuthor(Author author) {

    }

    public Author getAuthorById(long id) {
        return null;
    }

    public void deleteAuthor(long id) {

    }
}
