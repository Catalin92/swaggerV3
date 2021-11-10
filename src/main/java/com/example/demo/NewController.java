package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class NewController {

    @PostMapping(value ="/zzzz", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public Author postBook(@RequestBody Author author){
        //save book
        System.out.println(author);
        return author;
    }


    @PostMapping(value ="/tttt", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public NewObject postNewObj(@RequestBody NewObject newObject){
        //save book
        System.out.println(newObject);
        return newObject;
    }
}
