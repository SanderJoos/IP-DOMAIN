package services;

import db.actorDB.AuthorRepositoryFactory;
import db.actorDB.IAuthorRepository;
import entities.Author;
import entities.Book;

import java.util.List;

/**
 * @author Sander Joos
 */
public class AuthorService{

    private IAuthorRepository authorRepository;

    public AuthorService(String repositoryKind){
        this.authorRepository = new AuthorRepositoryFactory().getAuthorRepository(repositoryKind);
    }

    public IAuthorRepository getAuthorRepository() {
        return authorRepository;
    }

    public void setActorRepository(String authorRepositoryKind) {
        //TODO
        this.authorRepository = new AuthorRepositoryFactory().getAuthorRepository(authorRepositoryKind);
    }


    public List<Author> getAllAuthors() {
        return this.getAuthorRepository().getAllAuthors();
    }

    public Author getAuthor(String name, String lastName) {
        return this.getAuthorRepository().getAuthor(name, lastName);
    }

    public Author getAuthor(String lastName) {
        return this.getAuthorRepository().getAuthor(lastName);
    }

    public List<Book> getBooksFromAuthor(String name, String lastName) {
        return this.getAuthorRepository().getBooksFromAuthor(name, lastName);
    }

    public List<Book> getBooksFromAuthor(String lastName) {
        return this.getAuthorRepository().getBooksFromAuthor(lastName);
    }

    public void addAuthor(Author author) {
        this.getAuthorRepository().addAuthor(author);
    }

    public void deleteAuthor(Author author) {
        this.getAuthorRepository().deleteAuthor(author);
    }

    public void deleteAuthor(String lastName) {
        this.getAuthorRepository().deleteAuthor(lastName);
    }

    public void updateAuthor(Author author){
        this.getAuthorRepository().updateAuthor(author);
    }

    public Author getAuthorById(long id){
        return this.getAuthorRepository().getAuthorById(id);
    }

    public void deleteAuthor(long id){
        this.authorRepository.deleteAuthor(id);
    }

}
