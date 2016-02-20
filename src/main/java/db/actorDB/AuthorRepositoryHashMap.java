package db.actorDB;

import entities.Author;
import entities.Book;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Sander Joos
 */
public class AuthorRepositoryHashMap implements IAuthorRepository {

    private HashMap<String, Author> authors;

    public AuthorRepositoryHashMap(){ this.authors = new HashMap<String, Author>(); }

    public List<Author> getAllAuthors() {
        return new ArrayList<Author>(this.authors.values());
    }

    public Author getAuthor(String lastName) {
        return this.authors.get(lastName);
    }

    public List<Book> getBooksFromAuthor(String name, String lastName) {
        return this.getBooksFromAuthor(lastName);
    }

    public void deleteAuthor(Author author) {
        this.authors.remove(author.getLastName());
    }

    public void deleteAuthor(String lastName) {
        this.authors.remove(lastName);
    }

    public void addAuthor(Author author) {
        this.authors.put(author.getLastName(),author);
    }

    public List<Book> getBooksFromAuthor(String lastName) {
        return this.authors.get(lastName).getBooks();
    }

    public Author getAuthor(String name, String lastName) {
        return this.getAuthor(lastName);
    }

}
