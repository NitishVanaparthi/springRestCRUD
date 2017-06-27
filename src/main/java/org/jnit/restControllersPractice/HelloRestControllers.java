package org.jnit.restControllersPractice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestControllers {

    

    @RequestMapping("/greeting")
    public Customer greeting(@RequestParam(value="name", defaultValue="World") String name) {
       //getStudnet(name);
    	Customer customer = new Customer();
    	customer.setId("1234");
    	customer.setName("ShivaYadav");
    	customer.setProduct("Rice");
    	
    	
    	return customer;
    }
}