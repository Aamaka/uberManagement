package africa.semicolon.ubermanagement.exception;

import org.springframework.http.HttpStatus;

public class UserException extends Exception {
    private HttpStatus status;
    public UserException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
