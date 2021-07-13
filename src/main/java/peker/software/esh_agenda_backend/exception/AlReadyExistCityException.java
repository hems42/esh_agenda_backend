package peker.software.esh_agenda_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class AlReadyExistCityException extends RuntimeException{
    public AlReadyExistCityException(String message) {
        super(message);
    }
}
