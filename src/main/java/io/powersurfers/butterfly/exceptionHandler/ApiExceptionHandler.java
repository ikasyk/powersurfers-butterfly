package io.powersurfers.butterfly.exceptionHandler;

import io.powersurfers.butterfly.exception.NoSuchUserException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchUserException.class)
    protected ResponseEntity<ApiException> handleThereIsNoSuchUserException() {
        return new ResponseEntity<>(new ApiException("There is no such user"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class ApiException {
        private String message;
    }
}
