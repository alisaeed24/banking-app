package banking.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ErrorDetialsDto> handleAccountException(AccountException accountException, WebRequest webRequest){
        ErrorDetialsDto errorDetialsDto = new ErrorDetialsDto(LocalDateTime.now(),accountException.getMessage(), webRequest.getDescription(false),"ACCOUNT_NOT_FOUND" );
        return new ResponseEntity<>(errorDetialsDto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetialsDto> handleGlobalException(Exception exception, WebRequest webRequest){
        ErrorDetialsDto errorDetialsDto = new ErrorDetialsDto(LocalDateTime.now(),exception.getMessage(), webRequest.getDescription(false),"INTERNAL_SERVER_ERROR" );
        return new ResponseEntity<>(errorDetialsDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
