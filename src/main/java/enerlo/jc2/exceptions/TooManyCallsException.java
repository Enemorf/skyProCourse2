package enerlo.jc2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TooManyCallsException extends RuntimeException
{
    public TooManyCallsException (String message)
    {
        super(message);
    }
}
