/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainDebug;

import entities.Author;
import services.ServiceFacade;

public class Main {
    
    public static void main(String[] args){
        ServiceFacade facade = new ServiceFacade("postgresql");
        Author a = new Author("a","a");
        Author b = new Author("b","b");
        facade.addAuthor(a);
        facade.addAuthor(b);
        System.out.println(facade.getAllAuthors());
        System.out.println(facade.getAuthorById(a.getId()));
        facade.deleteAuthor(1);
        System.out.println(facade.getAllAuthors());       
    }
    
}
