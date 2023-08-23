package enerlo.jc2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.BAD_REQUEST, reason = "Too many calls to the service")
public class TooManyCallsException extends RuntimeException
{
}
