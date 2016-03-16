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

    //TODO replace all actors in authors

    private IAuthorRepository actorRepository;

    public AuthorService(){
        this.actorRepository = new AuthorRepositoryFactory().getActorRepository("hashMap");
    }

    public IAuthorRepository getActorRepository() {
        return actorRepository;
    }

    public void setActorRepository(String authorRepositoryKind) {
        //TODO
        this.actorRepository = new AuthorRepositoryFactory().getActorRepository(authorRepositoryKind);
    }


    public List<Author> getAllAuthors() {
        return this.getActorRepository().getAllAuthors();
    }

    public Author getAuthor(String name, String lastName) {
        return this.getActorRepository().getAuthor(name, lastName);
    }

    public Author getAuthor(String lastName) {
        return this.getActorRepository().getAuthor(lastName);
    }

    public List<Book> getBooksFromAuthor(String name, String lastName) {
        return this.getActorRepository().getBooksFromAuthor(name, lastName);
    }

    public List<Book> getBooksFromAuthor(String lastName) {
        return this.getActorRepository().getBooksFromAuthor(lastName);
    }

    public void addAuthor(Author author) {
        this.getActorRepository().addAuthor(author);
    }

    public void deleteAuthor(Author author) {
        this.getActorRepository().deleteAuthor(author);
    }

    public void deleteAuthor(String lastName) {
        this.getActorRepository().deleteAuthor(lastName);
    }

}
