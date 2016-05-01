package db.actorDB;

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
        try{
            TypedQuery<Author> query = manager.createQuery("select a from Author a where a.lastName  > :lastName", Author.class);
            return query.setParameter("lastName", lastName).getSingleResult();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<Book> getBooksFromAuthor(String name, String lastName) {
        return this.getBooksFromAuthor(lastName);
    }

    public List<Book> getBooksFromAuthor(String lastName) {
        TypedQuery<Author> query = manager.createQuery("select a from Author a where a.lastName > :lastName", Author.class);
        return query.setParameter("lastName", lastName).getSingleResult().getBooks();
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
        try{
            Query query = manager.createQuery("delete from Author a where a.lastName = :lastName");
            query.setParameter("lastName",lastName).executeUpdate();
        }
        catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }
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
        return this.getAuthor(lastName);
    }

    public void updateAuthor(Author author) {
        manager.getTransaction().begin();
        Author a = this.getAuthorById(author.getId());
        a.setId(author.getId());
        a.setLastName(author.getLastName());
        a.setName(author.getName());
        manager.flush();
        manager.getTransaction().commit();
    }

    public Author getAuthorById(long id) {
        return manager.find(Author.class, id);
    }

    public void deleteAuthor(long id) {
        Author author = this.getAuthorById(id);
        manager.getTransaction().begin();
        manager.remove(author);
        manager.getTransaction().commit();
    }
}
