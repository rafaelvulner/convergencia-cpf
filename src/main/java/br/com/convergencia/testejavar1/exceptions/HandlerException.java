package br.com.convergencia.testejavar1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(InvalidCpfException.class)
    public ResponseEntity<?> handleInvalidCpfException(InvalidCpfException exc) {

        Map<String, Object> error = new LinkedHashMap<>();

        error.put("date", LocalDateTime.now());
        error.put("message", "Format invalid");
        error.put("status", HttpStatus.BAD_REQUEST);
        error.put("error", exc.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
