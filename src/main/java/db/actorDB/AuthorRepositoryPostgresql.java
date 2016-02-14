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

    @Override
    public Author getAuthor(String lastName) {
        return null;
    }

    @Override
    public List<Book> getBooksFromAuthor(String name, String lastName) {
        return null;
    }

    @Override
    public List<Book> getBooksFromAuthor(String lastName) {
        return null;
    }

    @Override
    public void addAuthor(Author author) {

    }

    @Override
    public void deleteAuthor(Author author) {

    }

    @Override
    public void deleteAuthor(String lastName) {

    }

    @Override
    public List<Author> getAllAuthors() {
        return null;
    }

    @Override
    public Author getAuthor(String name, String lastName) {
        return null;
    }
}
