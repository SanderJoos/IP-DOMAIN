package db.actorDB;

import entities.Author;
import entities.Book;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * @Author Sander Joos
 */
public class AuthorRepositoryHashMap implements IAuthorRepository {

    private HashMap<String, Author> authors;

    public AuthorRepositoryHashMap(){
        this.authors = new HashMap<String, Author>();
    }

    @Override
    public List<Author> getAllAuthors() {
        return new ArrayList<Author>(this.authors.values());
    }

    @Override
    public Author getAuthor(String lastName) {
        return this.authors.get(lastName);
    }

    @Override
    public List<Book> getBooksFromAuthor(String name, String lastName) {
        return this.getBooksFromAuthor(lastName);
    }

    @Override
    public void deleteAuthor(Author author) {
        this.authors.remove(author.getLastName());
    }

    @Override
    public void deleteAuthor(String lastName) {
        this.authors.remove(lastName);
    }

    @Override
    public void addAuthor(Author author) {
        this.authors.put(author.getLastName(),author);
    }

    @Override
    public List<Book> getBooksFromAuthor(String lastName) {
        return this.authors.get(lastName).getBooks();
    }

    @Override
    public Author getAuthor(String name, String lastName) {
        return this.getAuthor(lastName);
    }

}
