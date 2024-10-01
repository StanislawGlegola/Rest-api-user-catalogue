package pl.sg.subscribers.exceptions;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleServerError(Exception e) {
        return new ResponseEntity<>("Undefined request error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        return new ResponseEntity<>("No User found with provided ID. Stacktrace: " + e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException e) {
        return new ResponseEntity<>("A required field is missing: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SubscriptionExceptions.class)
    public ResponseEntity<String> handleSubscriptionExceptions(SubscriptionExceptions e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<String> handleDuplicateKeyException(SubscriptionExceptions e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}