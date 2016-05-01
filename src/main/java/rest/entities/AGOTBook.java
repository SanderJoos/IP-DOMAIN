/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Sander_2
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AGOTBook {
    
    String name;
    String isbn;
    int numberOfPages;
    String publisher;
    String country;
    String mediaType;
    String released;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    @Override
    public String toString() {
        return "AGOTBook{" + "name=" + name + ", isbn=" + isbn + ", numberOfPages=" + numberOfPages + ", publisher=" + publisher + ", country=" + country + ", mediaType=" + mediaType + ", released=" + released + '}';
    }
    
    
}
