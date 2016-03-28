package entities;

import Exceptions.DomainException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Sander Joos
 */

@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;
    
    String title;
    String ISBN;
    int score;

    public Book(){

    }

    public Book(String title, String ISBN, int score){
        this.setISBN(ISBN);
        this.setScore(score);
        this.setTitle(title);
    }

    public Book(String title, String ISBN, int score, long id){
        this.setISBN(ISBN);
        this.setScore(score);
        this.setTitle(title);
        this.setId(id);
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public long getId(){
        return this.id;
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
}
