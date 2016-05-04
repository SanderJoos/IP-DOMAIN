package db.actorDB;

import Exceptions.DatabaseException;
import entities.Author;
import entities.Book;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Sander Joos
 */
public class AuthorRepositoryInMemory implements IAuthorRepository {
    
    private static int counter = 0;

    private static Map<Long, Author> authorsById;

    public AuthorRepositoryInMemory(){
        this.authorsById = new HashMap<Long, Author>();
    }
    
    public static int getNextID(){
        counter++;
        return counter;
    }

    public List<Author> getAllAuthors() {
        return new ArrayList<Author>(this.authorsById.values());
    }

    public Author getAuthor(String lastName) {
        if(lastName.isEmpty()){
            throw new DatabaseException("An author can't be found based on an empty lastName");
        }
        List<Author> authors = this.getAllAuthors();
        for (Author a : authors) {
            if (a.getLastName().equals(lastName)) {
                return a;
            }
        }
        return null;
    }

    public List<Book> getBooksFromAuthor(String name, String lastName) {
        if(lastName.isEmpty()){
            throw new DatabaseException("Book can't be found based on an empty lastName");
        }
        return this.getBooksFromAuthor(lastName);
    }

    public void deleteAuthor(Author author) {
        if(author == null){
            throw new DatabaseException("We can't delete a non existing author");
        }
        this.authorsById.remove(author.getId());
    }

    public void deleteAuthor(String lastName) {
        if(lastName.isEmpty()){
            throw new DatabaseException("We can't delete an author based on an empty name");
        }
        Author author = this.getAuthor(lastName);
        this.authorsById.remove(author.getId());
    }

    public void addAuthor(Author author) {
        if(author == null){
            throw new DatabaseException("We can't add a non existing author");
        }
        author.setId(AuthorRepositoryInMemory.getNextID());
        this.authorsById.put(author.getId(),author);
    }

    public List<Book> getBooksFromAuthor(String lastName) {
        return this.getAuthor(lastName).getBooks();
    }

    public Author getAuthor(String name, String lastName) {
        if(lastName.isEmpty()){
            throw new DatabaseException("We can't find an author if you don't provide credentials");
        }
        return this.getAuthor(lastName);
    }

    public Author getAuthorById(long id){
        return this.authorsById.get(id);
    }

    public void updateAuthor(Author author) {
        if (author == null) {
            throw new DatabaseException("We can't update an author if we don't know which one");
        }
        this.authorsById.remove(author.getId());
        this.authorsById.put(author.getId(), author);
    }

    public void deleteAuthor(long id){
        Author author = this.authorsById.get(id);
        this.authorsById.remove(id);
    }

    public void closeConnection() {
       System.out.println("I is hashmap");
    }

}
