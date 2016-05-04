package entities;

import Exceptions.DomainException;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.*;
import javax.validation.constraints.*;

/**
 * @author Sander Joos
 * @version 1.0.0
 */
@Entity
public class Author {

    @NotNull(message="name may not be null")
    private String name;
    
    @NotNull(message="last name may not be null")
    private String lastName;
    
    private double averageScore;

    @OneToMany
    @Valid
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    @Id
    @GeneratedValue
    private long id;

    public Author(){
        this.books = new ArrayList<Book>();
        this.averageScore = 0;
    }

    public Author(String name, String lastName){
        this.setName(name);
        this.setLastName(lastName);
        this.setBooks(new ArrayList<Book>());
        this.averageScore = 0;
    }

    public Author(String name, String lastName, long id){
        this.setName(name);
        this.setLastName(lastName);
        this.setBooks(new ArrayList<Book>());
        this.setId(id);
        this.averageScore = 0;
    }
    
    public void setAverageScore(double score){
        this.averageScore = score;
    }
    
    public double getAverageScore(){
        return this.averageScore;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty()){
            throw new DomainException("This isn't a valid name");
        }
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.isEmpty()){
            throw new DomainException("This isn't a valid lastName");
        }
        this.lastName = lastName;
    }
    
    

    public void addBook(Book book){
        if(! this.books.contains(book)) {
            this.books.add(book);
        }
        this.setAverageScore(this.calculateAverageScore());
    }

    public double calculateAverageScore() {
        if(this.getBooks().size() == 0){
            return 0;
        }
        double score = 0;
        for(Book book : this.getBooks()){
            score =+ book.getScore();
        }
        return score/(this.getBooks().size());
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Author){
            Author a = (Author) o;
            if(a.name.equals(this.name) && a.lastName.equals(this.lastName) && a.id == this.id){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                ", id=" + id +
                ", averageScore=" + averageScore +
                '}';
    }
}
