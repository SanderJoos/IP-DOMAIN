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
public class AuthorRepositoryHashMap implements IAuthorRepository {

    private static Map<String, Author> authors;
    private static Map<Long, Author> authorsById;

    public AuthorRepositoryHashMap(){
        this.authors = new HashMap<String, Author>();
        this.authorsById = new HashMap<Long, Author>();
        this.addAuthor(new Author("Patrick","Rothfuss"));
        this.addAuthor(new Author("Brandon","Sanderson"));
    }

    public List<Author> getAllAuthors() {
        return new ArrayList<Author>(this.authors.values());
    }

    public Author getAuthor(String lastName) {
        if(lastName.isEmpty()){
            throw new DatabaseException("An author can't be found based on an empty lastName");
        }
        return this.authors.get(lastName);
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
        this.authors.remove(author.getLastName());
        this.authorsById.remove(author.getId());
    }

    public void deleteAuthor(String lastName) {
        if(lastName.isEmpty()){
            throw new DatabaseException("We can't delete an author based on an empty name");
        }
        Author author = this.getAuthor(lastName);
        this.authors.remove(author.getLastName());
        this.authorsById.remove(author.getId());
    }

    public void addAuthor(Author author) {
        if(author == null){
            throw new DatabaseException("We can't add a non existing author");
        }
        this.authors.put(author.getLastName(),author);
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

    public void updateAuthor(Author author){
        if(author == null){
            throw new DatabaseException("We can't update an author if we don't know which one");
        }
        long id = author.getId();
        Author toRemove = null;
        if(this.authorsById.get(id) != null){
            toRemove = authorsById.get(id);
        }
        this.deleteAuthor(toRemove);
        this.authors.put(author.getLastName(), author);
        this.authorsById.put(author.getId(),author);
    }

    public void deleteAuthor(long id){
        Author author = this.authorsById.get(id);
        this.authors.remove(author.getLastName());
        this.authors.remove(id);
    }

}
