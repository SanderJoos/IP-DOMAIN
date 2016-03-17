package entities;

import Exceptions.DomainException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sander Joos
 * @version 0.0.1
 */
public class Author {

    private String name;
    private String lastName;

    private List<Book> books;

    private static long Id = 0;
    private long id;

    public Author(){
        this.books = new ArrayList<Book>();
    }

    public Author(String name, String lastName){
        this.setName(name);
        this.setLastName(lastName);
        this.books = new ArrayList<Book>();
        this.setId(Author.getNextId());
    }

    public Author(String name, String lastName, long id){
        this.setName(name);
        this.setLastName(lastName);
        this.books = new ArrayList<Book>();
        this.setId(id);
    }

    public long getId() {
        return id;
    }

    public static long getNextId(){
        Author.Id++;
        return Author.Id;
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

    public List<Book> getBooks(){
        return this.books;
    }

    public void addBook(Book book){
        if(! this.books.contains(book)) {
            this.books.add(book);
        }
    }

    public double getAverageScore() {
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
                '}';
    }
}
