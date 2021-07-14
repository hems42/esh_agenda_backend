package peker.software.esh_agenda_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class AlreadyExistPhoneNumberException extends RuntimeException{
    public AlreadyExistPhoneNumberException(String message) {
        super(message);
    }
}
