package io.bimlu.learn.spring.boot.ExceptionHandling.exception;

import io.bimlu.learn.spring.boot.ExceptionHandling.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleBookNotFoundException(final BookNotFoundException ex) {

        ErrorDTO error = new ErrorDTO(
                "Invalid Book",
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                ex.getClass().getSimpleName(),
                "B001"
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleOtherException(final Exception ex) {

        ErrorDTO error = new ErrorDTO(
                null,
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getClass().getSimpleName(),
                "C001"
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
