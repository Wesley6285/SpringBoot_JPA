package com.example.demo.Exception;

public class BookNotFoundException extends RuntimeException {
    
    public BookNotFoundException(String message){
        super(message);
    }
}
