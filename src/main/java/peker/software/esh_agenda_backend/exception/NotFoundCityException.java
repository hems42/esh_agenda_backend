package peker.software.esh_agenda_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NotFoundCityException extends RuntimeException{
    public NotFoundCityException(String message) {
        super(message);
    }
}