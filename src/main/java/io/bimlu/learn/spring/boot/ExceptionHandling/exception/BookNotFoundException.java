package io.bimlu.learn.spring.boot.ExceptionHandling.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
