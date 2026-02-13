package ricksciascia.u5d10.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ricksciascia.u5d10.payloads.ErrorsListDTO;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ValException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsListDTO handleValEx(ValException ex) {
        return new ErrorsListDTO(ex.getMessage(), LocalDateTime.now(),ex.getListaErrori());
    }
}
