package db.actorDB;

import entities.Author;
import entities.Book;

import java.util.List;

/**
 * @author Sander Joos
 */
public class AuthorRepositoryPostgresql implements IAuthorRepository {


    public AuthorRepositoryPostgresql(){

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

    public void addAuthor(Author author) {

    }

    public void deleteAuthor(Author author) {

    }

    public void deleteAuthor(String lastName) {

    }

    public List<Author> getAllAuthors() {
        return null;
    }

    public Author getAuthor(String name, String lastName) {
        return null;
    }
}
