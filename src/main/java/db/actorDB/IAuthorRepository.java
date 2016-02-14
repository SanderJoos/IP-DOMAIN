package db.actorDB;

import entities.Author;
import entities.Book;

import java.util.List;

/**
 * @author Sander Joos
 */
public interface IAuthorRepository {

    List<Author> getAllAuthors();
    Author getAuthor(String name, String lastName);
    Author getAuthor(String lastName);
    List<Book> getBooksFromAuthor(String name, String lastName);
    List<Book> getBooksFromAuthor(String lastName);
    void addAuthor(Author author);
    void deleteAuthor(Author author);
    void deleteAuthor(String lastName);

}
