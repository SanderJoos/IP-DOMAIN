/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author Sander_2
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AGOTBookLibrary {
    
    private List<AGOTBook> books;

    public List<AGOTBook> getBooks() {
        return books;
    }

    public void setResults(List<AGOTBook> books) {
        this.books = books;
    }   

    @Override
    public String toString() {
        String toReturn ="";
        for(AGOTBook book : books){
            toReturn += books.toString() + "\n";
        }
        return toReturn;
    }    
}
