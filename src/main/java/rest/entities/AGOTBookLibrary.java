/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import restTemplateConfiguration.userAgentInterceptor;

/**
 *
 * @author Sander_2
 */


public class AGOTBookLibrary {
    
    private List<AGOTBook> AGOTBooks;
    
    RestTemplate restTemplate = new RestTemplate();
    
    ClientHttpRequestInterceptor interceptor = new userAgentInterceptor();
    
    public AGOTBookLibrary(){
        this.AGOTBooks = new ArrayList();
        List<ClientHttpRequestInterceptor> list = new ArrayList<ClientHttpRequestInterceptor>();
        list.add(interceptor);
        restTemplate.setInterceptors(list);
        
        AGOTBook book1 = restTemplate.getForObject("http://anapioficeandfire.com/api/books/1", AGOTBook.class);
        AGOTBook book2 = restTemplate.getForObject("http://anapioficeandfire.com/api/books/2", AGOTBook.class);
        AGOTBook book3 = restTemplate.getForObject("http://anapioficeandfire.com/api/books/3", AGOTBook.class);
        AGOTBook book4 = restTemplate.getForObject("http://anapioficeandfire.com/api/books/4", AGOTBook.class);
        AGOTBook book5 = restTemplate.getForObject("http://anapioficeandfire.com/api/books/5", AGOTBook.class);
        AGOTBook book6 = restTemplate.getForObject("http://anapioficeandfire.com/api/books/6", AGOTBook.class);
        AGOTBook book7 = restTemplate.getForObject("http://anapioficeandfire.com/api/books/7", AGOTBook.class);
        AGOTBook book8 = restTemplate.getForObject("http://anapioficeandfire.com/api/books/8", AGOTBook.class);
        AGOTBook book9 = restTemplate.getForObject("http://anapioficeandfire.com/api/books/9", AGOTBook.class);
        AGOTBook book10 = restTemplate.getForObject("http://anapioficeandfire.com/api/books/10", AGOTBook.class);
        
        AGOTBooks.add(book1);
        AGOTBooks.add(book2);
        AGOTBooks.add(book3);
        AGOTBooks.add(book4);
        AGOTBooks.add(book5);
        AGOTBooks.add(book6);
        AGOTBooks.add(book7);
        AGOTBooks.add(book8);
        AGOTBooks.add(book9);
        AGOTBooks.add(book10);
    }  

    public List<AGOTBook> getAGOTBooks() {
        return AGOTBooks;
    }

    public void setAGOTBooks(List<AGOTBook> AGOTBooks) {
        this.AGOTBooks = AGOTBooks;
    }

    @Override
    public String toString() {
        String toReturn ="";
        for(AGOTBook book : AGOTBooks){
            toReturn += book.toString() + "\n";
        }
        return toReturn;
    }    
}
