package entities;

import Exceptions.DomainException;

/**
 * @author Sander Joos
 */
public class Book {

    String title;
    String ISBN;
    int score;
    Author author;

    public Book(){

    }

    public Book(String title, String ISBN, int score){
        this.setISBN(ISBN);
        this.setScore(score);
        this.setTitle(title);
    }

    public Book(String title, String ISBN, int score,  Author author){
        this.setISBN(ISBN);
        this.setScore(score);
        this.setTitle(title);
        this.setAuthor(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.isEmpty()){
            throw new DomainException("This isn't a valid title");
        }
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        if(ISBN.isEmpty()){
            throw new DomainException("This isn't a valid ISBN");
        }
        this.ISBN = ISBN;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score < 0 || score > 10){
            throw new DomainException("This isn't a valid score");
        }
        this.score = score;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        if(author == null){
            throw new DomainException("This isn't a valid author");
        }
        if(this.author == null) {
            this.author = author;
            author.addBook(this);
        }
    }
}
