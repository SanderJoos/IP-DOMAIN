/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.main;

import org.springframework.web.client.RestTemplate;
import services.ServiceFacade;

/**
 *
 * @author Sander_2
 */
public class MainTest {
    
    public static void main(String[] args){
        ServiceFacade service = new ServiceFacade("hashMap");
        System.out.println(service.printAGOTBookLibrary());
    }
}

