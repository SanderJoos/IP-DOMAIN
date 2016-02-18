package entities;

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

    public Author(){
        this.books = new ArrayList<Book>();
    }

    public Author(String name, String lastName){
        this.setName(name);
        this.setLastName(lastName);
        this.books = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty()){
            throw new IllegalArgumentException("This isn't a valid name");
        }
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.isEmpty()){
            throw new IllegalArgumentException("This isn't a valid lastName");
        }
        this.lastName = lastName;
    }

    public List<Book> getBooks(){
        return this.books;
    }

    public void addBook(Book book){
        if(! this.books.contains(book)) {
            this.books.add(book);
            book.setAuthor(this);
        }
    }

    public double getAverageScore() {
        double score = 0;
        for(Book book : this.getBooks()){
            score =+ book.getScore();
        }
        return score/(this.getBooks().size());
    }

    public void removeBook(Book book){
        if(book == null){
            throw new IllegalArgumentException("This isn't a valid book to remove");
        }
        this.books.remove(book);
    }

}
