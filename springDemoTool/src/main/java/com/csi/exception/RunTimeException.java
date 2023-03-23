package com.csi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RunTimeException extends RuntimeException{
    public RunTimeException(String msg){
        super(msg);
    }
}
